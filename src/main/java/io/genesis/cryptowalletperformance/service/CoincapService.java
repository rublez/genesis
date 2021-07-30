package io.genesis.cryptowalletperformance.service;

import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import io.genesis.cryptowalletperformance.dto.Asset;
import io.genesis.cryptowalletperformance.dto.AssetData;
import io.genesis.cryptowalletperformance.dto.AssetHistoricalData;
import io.genesis.cryptowalletperformance.dto.AssetSymbolToIdType;
import io.genesis.cryptowalletperformance.dto.Data;
import io.genesis.cryptowalletperformance.dto.WalletAsset;
import io.genesis.cryptowalletperformance.repository.CoincapClient;

@Service
public class CoincapService {
	private final Logger log;

	private final CoincapClient coincapClient;

	public CoincapService(final CoincapClient coincapClient, final Logger log) {
		this.coincapClient = coincapClient;
		this.log = log;

	}

	public List<Asset> getAssetsUpdatedValues(final List<WalletAsset> walletAssets)
			throws InterruptedException, ExecutionException {
		List<Asset> assetValues = new CopyOnWriteArrayList<>();
		ForkJoinPool customThreadPool = new ForkJoinPool(3);
		assetValues = customThreadPool
				.submit(() -> walletAssets.parallelStream().map(this::getAsset).collect(Collectors.toList())).join();
		customThreadPool.shutdownNow();
		customThreadPool.awaitTermination(5, TimeUnit.SECONDS);

		if (customThreadPool.isTerminated())
			showAssetsRetrieved(assetValues);

		return assetValues;

	}

	public Data getAssetsHistoricalData(final String assetId) {
		AssetHistoricalData assetHistoricalData = coincapClient.getAssetHistoricalData(assetId);
		return null != assetHistoricalData && assetHistoricalData.getData().size() > 0
				? assetHistoricalData.getData().get(0)
				: null;

	}

	private void showAssetsRetrieved(final List<Asset> assets) throws InterruptedException, ExecutionException {
		for (Asset asset : assets) {
			log.debug(asset.toString());

		}

	}

	private Asset getAsset(final WalletAsset walletAsset) {
		String id = AssetSymbolToIdType.valueOf(walletAsset.getSymbol()).id;
		log.info(String.format("Submitted request %s at %s", id, LocalTime.now()));
		AssetData assetData = coincapClient.getAsset(id);

		return null != assetData ? assetData.getData() : null;

	}

}
