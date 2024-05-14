package com.bid.bid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bid.bid.dto.PlayerDto;
import com.bid.bid.entity.Players;
import com.bid.bid.serviceImplementation.PalyerServiceImp;

@RestController
@RequestMapping("/api/Player")
public class PlayersController {
	@Autowired
	PalyerServiceImp playersServiceImp;
	//Store the Player in DB
	@GetMapping("/HelloWorld")
	public String hi() {
		return "Hello World";
	}
	@PostMapping("/RegisterPlayer")
	public ResponseEntity<Players> CreatePlayer(@RequestBody PlayerDto players) {
		Players player=playersServiceImp.RegisterThePlayer(players);
		return new ResponseEntity<>(player,HttpStatus.CREATED);
	}
	@DeleteMapping("/{name}/DeletePlayer")
	public ResponseEntity<Players> DeletePlayer(@PathVariable(name="name") String name) {
		Players player=playersServiceImp.RemoveThePlayer(name);
		return new ResponseEntity<>(player,HttpStatus.CREATED);
	}
	@GetMapping("/{name}/DisplayPlayer")
	public ResponseEntity<Players> DisplayPlayer(@PathVariable(name="name") String name) {
		Players player=playersServiceImp.Display(name);
		return new ResponseEntity<>(player,HttpStatus.CREATED);
	}
}
