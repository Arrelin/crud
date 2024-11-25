package com.example.crud.service;

import com.example.crud.dto.MobileDTO;
import com.example.crud.dto.MobileUpdateDTO;

import java.util.List;

public interface MobileService {
    MobileDTO createMobile(MobileDTO mobileDTO);
    MobileDTO getMobileById(Long id);
    List<MobileDTO> getAllMobiles();
    MobileDTO updateMobile(Long id, MobileUpdateDTO mobileUpdateDTO);
    void deleteMobile(Long id);
}
