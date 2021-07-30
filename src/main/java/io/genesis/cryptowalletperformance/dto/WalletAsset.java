package io.genesis.cryptowalletperformance.dto;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Asset in client's wallet
 * 
 * @author rafael
 *
 */
public class WalletAsset {

	private String symbol;
	
	private BigDecimal quantity;
	
	private BigDecimal price;

	
	public WalletAsset() {
	}

	public WalletAsset(final String symbol, final BigDecimal quantity, final BigDecimal price) {
		this.symbol = symbol;
		this.quantity = quantity;
		this.price = price;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(final String symbol) {
		this.symbol = symbol;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(final BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, quantity, symbol);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WalletAsset other = (WalletAsset) obj;
		return Objects.equals(price, other.price) && Objects.equals(quantity, other.quantity)
				&& Objects.equals(symbol, other.symbol);
	}

	@Override
	public String toString() {
		return "Assets [symbol=" + symbol + ", quantity=" + quantity + ", price=" + price + "]";
	}

}
