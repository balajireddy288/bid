package com.bid.bid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BidSoldDto {
	public String name;
	public String SoldTeam;
	public int SoldPrice;
	public String PlayerCategory;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSoldTeam() {
		return SoldTeam;
	}
	public void setSoldTeam(String soldTeam) {
		this.SoldTeam = soldTeam;
	}
	public int getSoldPrice() {
		return SoldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.SoldPrice = soldPrice;
	}
	public String getPalyerCategory() {
		return PlayerCategory;
	}
	public void setPalyerCategory(String PlayerCategory) {
		this.PlayerCategory=PlayerCategory;
	}
}
