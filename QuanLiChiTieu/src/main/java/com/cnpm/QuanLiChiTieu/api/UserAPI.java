package com.cnpm.QuanLiChiTieu.api;

import com.cnpm.QuanLiChiTieu.entity.User;
import com.cnpm.QuanLiChiTieu.service.ChiTieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chitieu")
public class UserAPI {
    @Autowired
    private ChiTieuService chiTieuService;

    @GetMapping
    public List<User> getAllChiTieu() {
        return chiTieuService.getAllChiTieu();
    }

}
