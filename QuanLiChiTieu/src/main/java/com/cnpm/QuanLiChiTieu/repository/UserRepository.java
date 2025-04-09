package com.cnpm.QuanLiChiTieu.repository;

import com.cnpm.QuanLiChiTieu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
