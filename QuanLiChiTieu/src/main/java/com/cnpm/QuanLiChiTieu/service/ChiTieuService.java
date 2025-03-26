package com.cnpm.QuanLiChiTieu.service;

import com.cnpm.QuanLiChiTieu.entity.User;
import com.cnpm.QuanLiChiTieu.repository.ChiTieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTieuService {
    @Autowired
    private ChiTieuRepository chiTieuRepository;

    public List<User> getAllChiTieu() {
        return chiTieuRepository.findAll();
    }
}