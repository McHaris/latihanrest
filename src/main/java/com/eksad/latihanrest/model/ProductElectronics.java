package com.eksad.latihanrest.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue("Electronic")
@Table(name = "product_electronic")
@PrimaryKeyJoinColumn(name = "product_id")
public class ProductElectronics extends Produk{
	
	@Column(name = "power_supply", nullable = false)
	private String powerConsumption;

}
