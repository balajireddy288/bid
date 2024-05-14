package com.bid.bid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bid.bid.dto.BidSoldDto;
import com.bid.bid.entity.BidSold;
import com.bid.bid.serviceImplementation.BidSoldServiceImp;

@RestController
@RequestMapping("/api/bidSold")
public class BidSoldController {
	
	@Autowired
	BidSoldServiceImp bidSoldServiceImp;
	
	@GetMapping("/")
	public String hi() {
		return "Hello World";
	}
	
	@PostMapping("/BidRegister")
	public ResponseEntity<BidSold> CreatePlayer(@RequestBody BidSoldDto bidSoldDto) {
		//System.out.print(bidSoldDto.getSoldTeam());
		BidSold bidsold=bidSoldServiceImp.Sold(bidSoldDto);
		return new ResponseEntity<>(bidsold,HttpStatus.CREATED);
		//return null;
	}
}
