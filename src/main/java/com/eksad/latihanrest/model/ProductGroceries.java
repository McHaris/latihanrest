package com.eksad.latihanrest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@DiscriminatorValue("Grocery")
@Table(name = "product_groceries")
@PrimaryKeyJoinColumn(name = "product_id")
public class ProductGroceries extends Produk{
	
	@Column(name = "expiry_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;

}
