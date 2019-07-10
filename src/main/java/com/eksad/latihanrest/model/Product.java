package com.eksad.latihanrest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn (name = "type" )
public class Product extends BaseEntity {
	
	
	// generated valuenya bisa milih mau pake SEQUENCE atau IDENTITY
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, // kayak counter (penghitung) di database, digunakan kalau gaada default value nya
//			generator = "product_id")
//	@SequenceGenerator(name = "product_id",
	//		sequenceName = "product_id_seq",
		//	allocationSize = 1) // buat nandain kalo naiknya itu satu angka(ditambah 1 tiap ngeadd)
	
	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	 */
	
	// kenapa many to one? ini kan class produk, nah produk itu punya satu merk
	// contoh = laptop 1 laptop 2 itu brand nya lenovo
	// berarti laptop nya banyak, brandnya 1 yaitu lenovo, makanya bilangnya many to one
	// kalo ini di class brand, maka akan jadi one to many
	@ManyToOne // untuk ngasih tau ke jpa bahwa class ini punya relasi ke class Brand
	@JoinColumn(name = "brand_id") // ini tuh colomn nya yang mana yang mau di join
	private Brand brand;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private BigDecimal price; // sifatnya sama kayak double, diperuntukkan untuk uang
	
	@Transient
	private Long brandId;

}
