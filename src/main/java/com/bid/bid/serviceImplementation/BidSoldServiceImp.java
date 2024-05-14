package com.bid.bid.serviceImplementation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bid.bid.dto.BidSoldDto;
import com.bid.bid.entity.BidSold;
import com.bid.bid.entity.Players;
import com.bid.bid.exception.PlayerNotFound;
import com.bid.bid.repository.BidSoldRepo;
import com.bid.bid.repository.PlayersRepo;
import com.bid.bid.service.BidSoldService;

@Service
public class BidSoldServiceImp implements BidSoldService{

	@Autowired
	BidSoldRepo bidSoldRepo;
	
	@Autowired
	private PlayersRepo playersRepo;
	
	@Override
	public BidSold Sold(BidSoldDto bidSoldDto) {
		BidSold bidsold=new BidSold();
		Players Player=playersRepo.findByName(bidSoldDto.getName()).orElseThrow(
				()->new PlayerNotFound("Not Found"));
		bidsold.setName(bidSoldDto.getName());
		bidsold.setSoldPrice(bidSoldDto.getSoldPrice());
		bidsold.setSoldTeam(bidSoldDto.getSoldTeam());
		bidsold.setPalyerCategory(bidSoldDto.getPalyerCategory());
		bidsold.setPlayers(Player);
		bidSoldRepo.save(bidsold);
		return bidsold;
	}

	@Override
	public List<String> GetTheWinnerAndRunner() {
		List<BidSold> Bids=bidSoldRepo.findAll();
		HashMap<String,List<Players>> TeamPlayers=mapThePlyers(Bids);
		List<String> Teams=getTeams();
		List<Pair> TeamPoints=new ArrayList<Pair>();
		for(String team:Teams) {
			List<Players> players=TeamPlayers.get(team);
			int points=0;
			for(Players player:players) {
				points+=player.getPoints();
			}
			TeamPoints.add(new Pair(team,points));
		}
		TeamPoints.sort(new Comparator<Pair>(){

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.Points-o1.Points;
			}
		});
		List<String> WinnerTeams=new ArrayList<String>();
		WinnerTeams.add(TeamPoints.get(0).Team);
		WinnerTeams.add(TeamPoints.get(1).Team);
		return WinnerTeams;
	}

	private List<String> getTeams() {
		List<String> Teams=new ArrayList<String>();
		Teams.add("RCB");
		Teams.add("SRH");
		Teams.add("KKR");
		Teams.add("CSK");
		Teams.add("RR");
		Teams.add("PKXI");
		Teams.add("DC");
		Teams.add("MI");
		return Teams;
	}

	private HashMap<String, List<Players>> mapThePlyers(List<BidSold> bids) {
		HashMap<String,List<Players>> map=new HashMap<String,List<Players>>();
		for(BidSold bidSold:bids) {
			if(map.containsKey(bidSold.getSoldTeam())) {
				map.get(bidSold.getSoldTeam()).add(bidSold.getPlayers());
			}
			else {
				List<Players> player=new ArrayList<Players>();
				player.add(bidSold.getPlayers());
				map.put(bidSold.getSoldTeam(), player);
			}
		}
		return map;
	}
	public class Pair{
		public String Team;
		public int Points;
		public Pair(String Team,int Points) {
			this.Team=Team;
			this.Points=Points;
		}
	}
	
}
