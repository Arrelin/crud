package com.example.crud.service;

import com.example.crud.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MobileService {

    private final MobileRepository mobileRepository;
}
