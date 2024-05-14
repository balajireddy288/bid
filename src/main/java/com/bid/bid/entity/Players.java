package com.bid.bid.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Players",uniqueConstraints= {
		@UniqueConstraint(columnNames= {"name"})
})
public class Players {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="name", nullable=false)
	private String name;
	@Column(name="PlayersPoints",nullable=false)
	private long points;
	@Column(name="PlayersBasePrice",nullable=false)
	private long basePrice;
	@Column(name="PalyerCategory", nullable=false)
	private String PalyerCategory;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
		return PalyerCategory;
	}
	public void setPalyerCategory(String PlayerCategory) {
		this.PalyerCategory=PlayerCategory;
	}
}
