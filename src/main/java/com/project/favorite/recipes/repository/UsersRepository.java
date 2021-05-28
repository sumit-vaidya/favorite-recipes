package com.project.favorite.recipes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.favorite.recipes.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
