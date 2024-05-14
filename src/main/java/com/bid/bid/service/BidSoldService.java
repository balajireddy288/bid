package com.bid.bid.service;

import java.util.List;

import com.bid.bid.dto.BidSoldDto;
import com.bid.bid.entity.BidSold;

public interface BidSoldService {
	BidSold Sold(BidSoldDto bidSoldDto);
	List<String> GetTheWinnerAndRunner();
}
