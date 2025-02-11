package com.example.VprepU.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.VprepU.Model.User;

public interface UserRepository extends JpaRepository<User,Integer> {

	User save(int userId);

}
