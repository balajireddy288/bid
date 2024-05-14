package com.bid.bid.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bid.bid.entity.Players;

public interface PlayersRepo extends JpaRepository<Players,Long>{
	@Query("select p from Players p where p.name = ?1")
	Optional<Players> findByName(String name);
}
