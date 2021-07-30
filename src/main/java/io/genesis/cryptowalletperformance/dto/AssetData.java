package io.genesis.cryptowalletperformance.dto;

import java.util.Objects;

public class AssetData {

	private Asset data;

	private Long timestamp;

	public AssetData() {}

	public AssetData(final Asset data, final Long timestamp) {
		this.data = data;
		this.timestamp = timestamp;
	}

	public Asset getData() {
		return data;
	}

	public void setData(final Asset data) {
		this.data = data;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(final Long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, timestamp);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssetData other = (AssetData) obj;
		return Objects.equals(data, other.data) && Objects.equals(timestamp, other.timestamp);
	}

	@Override
	public String toString() {
		return "Data [data=" + data + ", timestamp=" + timestamp + "]";
	}

	
}
