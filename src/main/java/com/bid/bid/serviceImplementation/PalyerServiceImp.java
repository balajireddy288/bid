package com.bid.bid.serviceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bid.bid.dto.PlayerDto;
import com.bid.bid.entity.Players;
import com.bid.bid.repository.PlayersRepo;
import com.bid.bid.service.PalyersService;
import com.bid.bid.exception.PlayerNotFound;

import lombok.Data;

@Data
@Service
public class PalyerServiceImp implements PalyersService{
	@Autowired
	private PlayersRepo playersRepo;
	@Override
	public Players RegisterThePlayer(PlayerDto player) {
		Players SavedPlayer=PlayerDtoToEntity(player);
		Players SavedPlayerRepo=playersRepo.save(SavedPlayer);
		return SavedPlayerRepo;
	}

	@Override
	public Players RemoveThePlayer(String Name){
		Players RemovePlayer=playersRepo.findByName(Name).orElseThrow(
				()->new PlayerNotFound("Not Found"));
		playersRepo.delete(RemovePlayer);
		return RemovePlayer;
	}

	
	@Override
	public Players Display(String Name) {
		Players DisplayPlayer=playersRepo.findByName(Name).orElseThrow(
				()->new PlayerNotFound("Not Found"));
		return DisplayPlayer;
	}
	
	public Players PlayerDtoToEntity(PlayerDto player) {
		Players SavedPlayer=new Players();
		SavedPlayer.setName(player.getName());
		SavedPlayer.setPoints(player.getPoints());
		SavedPlayer.setBasePrice(player.getBasePrice());
		SavedPlayer.setPalyerCategory(player.getPalyerCategory());
		return SavedPlayer;
	}
	
}
