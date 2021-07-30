package io.genesis.cryptowalletperformance.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Performance {

	private BigDecimal total = BigDecimal.ZERO;

	private String best_asset;

	private BigDecimal best_performance = BigDecimal.ZERO;

	private String worst_asset;

	private BigDecimal worst_performance;

	public Performance() {
	}

	public Performance(final BigDecimal total, final String best_asset, final BigDecimal best_performance,
			final String worst_asset, final BigDecimal worst_performance) {
		this.total = total;
		this.best_asset = best_asset;
		this.best_performance = best_performance;
		this.worst_asset = worst_asset;
		this.worst_performance = worst_performance;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(final BigDecimal total) {
		this.total = total;
	}

	public String getBest_asset() {
		return best_asset;
	}

	public void setBest_asset(final String best_asset) {
		this.best_asset = best_asset;
	}

	public BigDecimal getBest_performance() {
		return best_performance;
	}

	public void setBest_performance(final BigDecimal best_performance) {
		this.best_performance = best_performance;
	}

	public String getWorst_asset() {
		return worst_asset;
	}

	public void setWorst_asset(final String worst_asset) {
		this.worst_asset = worst_asset;
	}

	public BigDecimal getWorst_performance() {
		return worst_performance;
	}

	public void setWorst_performance(final BigDecimal worst_performance) {
		this.worst_performance = worst_performance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(best_asset, best_performance, total, worst_asset, worst_performance);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Performance other = (Performance) obj;
		return Objects.equals(best_asset, other.best_asset) && Objects.equals(best_performance, other.best_performance)
				&& Objects.equals(total, other.total) && Objects.equals(worst_asset, other.worst_asset)
				&& Objects.equals(worst_performance, other.worst_performance);
	}

	@Override
	public String toString() {
		return "Performance [total=" + total + ", best_asset=" + best_asset + ", best_performance=" + best_performance
				+ ", worst_asset=" + worst_asset + ", worst_performance=" + worst_performance + "]";
	}

}
