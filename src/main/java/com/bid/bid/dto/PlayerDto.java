package com.bid.bid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlayerDto {
	private  String name;
	private  long points;
	private long basePrice;
	public String PlayerCategory;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPoints() {
		return points;
	}
	public void setPoints(long points) {
		this.points = points;
	}
	public long getBasePrice() {
		return basePrice;
	}
	public void setBasePrice(long basePrice) {
		this.basePrice = basePrice;
	}
	public String getPalyerCategory() {
		return PlayerCategory;
	}
	public void setPalyerCategory(String palyerCategory) {
		PlayerCategory = palyerCategory;
	}
}
