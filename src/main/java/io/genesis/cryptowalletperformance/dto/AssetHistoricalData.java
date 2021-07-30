package io.genesis.cryptowalletperformance.dto;

import java.util.List;
import java.util.Objects;

public class AssetHistoricalData {

	private List<Data> data;

	private Long timestamp;

	public AssetHistoricalData() {
	}

	public AssetHistoricalData(final List<Data> data, final Long timestamp) {
		this.data = data;
		this.timestamp = timestamp;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(final List<Data> data) {
		this.data = data;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetHistoricalData other = (AssetHistoricalData) obj;
		return Objects.equals(data, other.data) && Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "Data [data=" + data + ", timestamp=" + timestamp + "]";
	}

}
