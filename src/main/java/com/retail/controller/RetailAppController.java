package com.retail.controller;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.dto.Shop;
import com.retail.repository.ShopRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("retail")
@Slf4j
public class RetailAppController {

	
		@Autowired
		private ShopRepository shopRepository;
		
		
		
		@GetMapping("/shops")
		public List<Shop> getAllShops() {
			return shopRepository.findAll();
		}
		
		
		
		@GetMapping("/shops/get")
		public Page<Shop> getClientPage(@RequestParam("page") int page ,@RequestParam("size")int size){
			Pageable pageable = PageRequest.of(page, size, Sort.by(Direction.DESC, "longitude","latitude"));
			return shopRepository.findAll(pageable);
		}

		
		
	
		@GetMapping(value="/shop/name/{shopName}"  ,produces= MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findShopByName(@PathVariable("shopName") String shopName) {
			log.info("Inside Controller /shop request");
			return new ResponseEntity<>(shopRepository.findByShopName(shopName),HttpStatus.OK);
		}
		
		
		
		
		@GetMapping(value="/shop/id/{id}" ,produces= MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> findShopById(@PathVariable("id") Integer id) {
			log.info("Inside Controller /shop request");
			return new ResponseEntity<>(shopRepository.findById(id),HttpStatus.OK);
		}
		
		
		
		
		@PostMapping(value="/shop/" ,consumes= MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_PROBLEM_JSON_VALUE)
		public ResponseEntity<?> createShop(@RequestBody Shop shop) {
			log.info("Inside Controller /shop request");
			return new ResponseEntity<>(shopRepository.save(shop),HttpStatus.CREATED);
		}
		
		
		
		
		
		@PutMapping(value="/shop/id/{id}" ,consumes= MediaType.APPLICATION_JSON_VALUE , produces=MediaType.APPLICATION_PROBLEM_JSON_VALUE)
		public ResponseEntity<?> upsert(@RequestBody Shop newShop ,@PathVariable("id") Integer id) {
			log.info("Inside Controller /shop request");
			shopRepository.findById(id)
			.map(existingShop-> updateExistingShop(existingShop, newShop))
			.orElseGet(pushNewShopToRepo(newShop, id));

			return new ResponseEntity<>(shopRepository.save(newShop),HttpStatus.ACCEPTED);
		}

		
	
		
		
		
		private Supplier<? extends Shop> pushNewShopToRepo(Shop newShop, Integer id) {
			return () -> {
				newShop.setId(id) ;
				return shopRepository.save(newShop);
			};
		}

		
		
		private Shop updateExistingShop(Shop existingShop,  Shop newShop) {
			existingShop.setAddress(newShop.getAddress());
			existingShop.setCategory(newShop.getCategory());
			existingShop.setLatitude(newShop.getLatitude());
			existingShop.setLongitude(newShop.getLongitude());
			existingShop.setOwnerName(newShop.getOwnerName());
			existingShop.setShopName(newShop.getShopName());
			return shopRepository.save(existingShop);

		}
		
	
}
