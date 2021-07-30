package io.genesis.cryptowalletperformance.dto;

/**
 * Consider you've got all names and codes here..
 * 
 * @author rafael
 *
 */
public enum AssetSymbolToIdType {

	BTC("bitcoin"), 
	ETH("ethereum"), 
	DOGE("dogecoin"), 
	NEO("neo"), 
	BTT("bittorrent"), 
	XLM("stellar"), 
	LTC("litecoin"),
	ATOM("cosmos");

	public final String id;

	private AssetSymbolToIdType(final String id) {
		this.id = id;

	}

}
