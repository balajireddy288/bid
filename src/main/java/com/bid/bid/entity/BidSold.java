package com.bid.bid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="BidSold",uniqueConstraints= {
		@UniqueConstraint(columnNames= {"name"})
})
public class BidSold {
	@Id
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="SoldTeam", nullable=false)
	private String SoldTeam;
	@Column(name="SoldPrice", nullable=false)
	private int SoldPrice;
	@Column(name="PalyerCategory", nullable=false)
	private String PalyerCategory;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Players_id")
	private Players players;
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
	public void setPlayers(Players player) {
		this.players=player;
	}
	public Players getPlayers() {
		return players;
	}
	public String getPalyerCategory() {
		return PalyerCategory;
	}
	public void setPalyerCategory(String PlayerCategory) {
		this.PalyerCategory=PlayerCategory;
	}
}
