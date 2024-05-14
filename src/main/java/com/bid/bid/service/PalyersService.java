package com.bid.bid.service;

import com.bid.bid.dto.PlayerDto;
import com.bid.bid.entity.Players;

public interface PalyersService {
	Players RegisterThePlayer(PlayerDto players);
	Players RemoveThePlayer(String Name);
	Players Display(String Name);
}
