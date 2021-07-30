package io.genesis.cryptowalletperformance.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Historical data about an asset
 * 
 * @author rafael
 *
 */
public class Data {

	@JsonProperty("priceUsd")
	private BigDecimal priceUsd;

	@JsonProperty("date")
	private Date date;

	@JsonProperty("time")
	private Long time;

	public Data() {
	}

	public Data(final BigDecimal priceUsd, final Date date, final Long time) {
		this.priceUsd = priceUsd;
		this.date = date;
		this.time = time;
	}

	public BigDecimal getPriceUsd() {
		return priceUsd;
	}

	public void setPriceUsd(final BigDecimal priceUsd) {
		this.priceUsd = priceUsd;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(final Long time) {
		this.time = time;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, priceUsd, time);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		return Objects.equals(date, other.date) && Objects.equals(priceUsd, other.priceUsd)
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return "AssetHistorical [priceUsd=" + priceUsd + ", date=" + date + ", time=" + time + "]";
	}

}
