/**

 * 
 */
package com.retail.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


/**
 * @author Usr
 *
 */
@Data
@Entity
	
public class Shop {
	@Id
	@Column(name="id")
	private  int id;

	@Column(name="shop_name")
	private String shopName;
	
	@Column(name="category")
	private String category;
	
	@Column(name="address")
	private String address;
	
	@Column(name="latitude")
	private String latitude;
	
	@Column(name="longitude")
	private String longitude;

	
	@Column(name="shop_owner")
	private String ownerName;
	

}
