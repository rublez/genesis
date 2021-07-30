/**
 * 
 */
package io.genesis.cryptowalletperformance.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.genesis.cryptowalletperformance.dto.WalletAsset;

/**
 * @author rafael
 *
 */
@ExtendWith(MockitoExtension.class)
class WalletServiceTest {

	@Mock
	WalletService walletService;
	
	/**
	 * Test method for {@link io.genesis.cryptowalletperformance.service.WalletService#getWalletData()}.
	 */
	@Test
	final void testGetWalletData() {
		try {
			Mockito.when(walletService.getWalletData()).thenReturn(
					Arrays.asList(
							new WalletAsset("BTC", new BigDecimal(0.12345), new BigDecimal(39960.4965)),
							new WalletAsset("ETH", new BigDecimal(4.89532), new BigDecimal(2303.2093)),
							new WalletAsset("BTT", new BigDecimal(12700), new BigDecimal(0.0028))));

			List<WalletAsset> walletAssets = walletService.getWalletData();

			Assertions.assertEquals(3, walletAssets.size());

		} catch (Exception e) {
			e.printStackTrace();

		}


	}

}
