package io.genesis.cryptowalletperformance.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.genesis.cryptowalletperformance.dto.AssetData;
import io.genesis.cryptowalletperformance.dto.AssetHistoricalData;

@FeignClient(value = "coincap", url = "http://api.coincap.io")
public interface CoincapClient {

	@RequestMapping(method = RequestMethod.GET, value = "/v2/assets/{id}")
	AssetData getAsset(@PathVariable("id") String asset);

	@RequestMapping(method = RequestMethod.GET, value = "/v2/assets/{id}/history?interval=d1&start=1617753600000&end=1617753601000")
	AssetHistoricalData getAssetHistoricalData(@PathVariable("id") String id);

}
