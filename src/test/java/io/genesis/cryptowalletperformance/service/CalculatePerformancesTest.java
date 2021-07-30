/**
 * 
 */
package io.genesis.cryptowalletperformance.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.genesis.cryptowalletperformance.dto.Asset;
import io.genesis.cryptowalletperformance.dto.Data;
import io.genesis.cryptowalletperformance.dto.Performance;
import io.genesis.cryptowalletperformance.dto.WalletAsset;

/**
 * @author rafael
 *
 */
@ExtendWith(MockitoExtension.class)
class CalculatePerformancesTest {

	@Mock
	WalletService walletService;

	@Mock
	CoincapService coincapService;
	
	@InjectMocks
	CalculatePerformances calculatePerformances;

	/**
	 * Test method for
	 * {@link io.genesis.cryptowalletperformance.service.CalculatePerformances#doTheMagic()}.
	 */
	@Test
	final void testDoTheMagic() {
		try {
			Mockito.when(walletService.getWalletData()).thenReturn(
					Arrays.asList(
							new WalletAsset("BTC", new BigDecimal(0.12345), new BigDecimal(39960.4965)),
							new WalletAsset("ETH", new BigDecimal(4.89532), new BigDecimal(2303.2093))));

			List<WalletAsset> walletAssets = walletService.getWalletData();

			Mockito.when(coincapService.getAssetsUpdatedValues(walletAssets))
					.thenReturn(Arrays.asList(
							new Asset("bitcoin", "BTC", "Bitcoin", new BigDecimal(39960.4965)),
							new Asset("ethereum", "ETH", "Ethereum", new BigDecimal(2303.2093))));

			List<Asset> assets = coincapService.getAssetsUpdatedValues(walletAssets);
			
			Mockito.when(coincapService.getAssetsHistoricalData("bitcoin"))
			.thenReturn(new Data(new BigDecimal(56999.972825205306729), new Date(), 1617753600000L));
			
			Mockito.when(coincapService.getAssetsHistoricalData("ethereum"))
			.thenReturn(new Data(new BigDecimal(2032.1394325557042107), new Date(), 1617753600000L));
			
			
			Performance performance = calculatePerformances.calculateValues(assets, walletAssets);
			
			Assertions.assertEquals(new BigDecimal(16208.0698).setScale(2,RoundingMode.CEILING), performance.getTotal().setScale(2,RoundingMode.CEILING));
			Assertions.assertEquals("ETH", performance.getBest_asset() );
			Assertions.assertEquals("BTC", performance.getWorst_asset() );					
			
//			Performance [total=16984.619289768000529688539728567786295919007975599944980371613922898177406750619411468505859375, 
//					best_asset=Bitcoin, 
//					best_performance=1.00, 
//					worst_asset=Bitcoin, 
//					worst_performance=1.00
//					]
			
			
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
