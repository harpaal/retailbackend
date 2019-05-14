/**
 * 
 */
package com.retail.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retail.dto.Shop;

/**
 * @author Usr
 *
 */
public interface ShopRepository extends JpaRepository<Shop, Integer> {
	
		public List<Shop> findByShopName(String shopName);
		
		public List<Shop> findByLongitude(String longitude);
		
		public List<Shop> findByLatitude(String latitude);
		
		public List<Shop> findByAddress(String address);
		
		public List<Shop> findByCategory(String category);
		
		public List<Shop> findByOwnerName(String ownerName);
		
}
