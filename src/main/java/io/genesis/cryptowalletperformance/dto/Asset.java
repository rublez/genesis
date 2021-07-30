package io.genesis.cryptowalletperformance.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Asset data in the moment
 * 
 * @author rafael
 *
 */
public class Asset {

	@JsonProperty("id")
	private String id;

	@JsonProperty("symbol")
	private String symbol;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("priceUsd")
	private BigDecimal priceUsd;

	
	public Asset() {
	}
	
	public Asset(final String id, final String symbol, final String name, final BigDecimal priceUsd) {
		this.id = id;
		this.symbol = symbol;
		this.name = name;
		this.priceUsd = priceUsd;
		
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(final BigDecimal priceUsd) {
		this.priceUsd = priceUsd;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, priceUsd, symbol);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asset other = (Asset) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(priceUsd, other.priceUsd) && Objects.equals(symbol, other.symbol);
	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", symbol=" + symbol + ", name=" + name + ", priceUsd=" + priceUsd + "]";
	}

}
