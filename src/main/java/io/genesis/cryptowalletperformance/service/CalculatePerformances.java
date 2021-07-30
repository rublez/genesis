package io.genesis.cryptowalletperformance.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.genesis.cryptowalletperformance.dto.Asset;
import io.genesis.cryptowalletperformance.dto.Data;
import io.genesis.cryptowalletperformance.dto.Performance;
import io.genesis.cryptowalletperformance.dto.WalletAsset;

@Service
public class CalculatePerformances {

	private final Logger log;
	private final WalletService walletService;
	private final CoincapService coincapService;

	@Autowired
	public CalculatePerformances(final Logger log, final WalletService walletService, final CoincapService coincapService) {
		this.log = log;
		this.walletService = walletService;
		this.coincapService = coincapService;

	}

	public void doTheMagic() throws Exception {

		// Read the wallet
		List<WalletAsset> walletAssets = walletService.getWalletData();

		// Get assets pricing
		List<Asset> assets = coincapService.getAssetsUpdatedValues(walletAssets);

		// Calculate and shows the wallet performance
		log.info(String.format("Final: %s", calculateValues(assets, walletAssets)));
		
	}

	Performance calculateValues(final List<Asset> assets, final List<WalletAsset> walletAssets) {
		BigDecimal total = BigDecimal.ZERO;
		total.setScale(4, RoundingMode.CEILING);
		
		BigDecimal qty = BigDecimal.ZERO;
		qty.setScale(4, RoundingMode.CEILING);
		Data data = new Data();
		Performance performance = new Performance();

		for (Asset asset : assets) {
			qty = BigDecimal.ZERO;
			data = getValues(asset.getId());

//			log.info(asset.getId() + ": " + data);

			BigDecimal variation = asset.getPriceUsd().divide(data.getPriceUsd(), 2, RoundingMode.CEILING);
			if (variation.compareTo(performance.getBest_performance()) > 0) {
				performance.setBest_asset(asset.getSymbol());
				performance.setBest_performance(variation);

			}
			if (null == performance.getWorst_performance()
					|| variation.compareTo(performance.getWorst_performance()) < 0) {
				performance.setWorst_asset(asset.getSymbol());
				performance.setWorst_performance(variation);

			}
			WalletAsset walletAsset = walletAssets.stream().filter(w -> w.getSymbol().equals(asset.getSymbol()))
					.findFirst().get();
			qty = walletAsset.getQuantity();
			total = total.add(qty.multiply(asset.getPriceUsd()));

//			log.info("Coin: " + asset.getName() + " | Variation: " + variation);

		}
		performance.setTotal(total);

		return performance;

	}

	private Data getValues(final String assetId) {
		return coincapService.getAssetsHistoricalData(assetId);

	}
	
}
