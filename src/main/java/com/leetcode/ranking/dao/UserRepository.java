package com.leetcode.ranking.dao;

import org.springframework.data.repository.CrudRepository;

import com.leetcode.ranking.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	
}
