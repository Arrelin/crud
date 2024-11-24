package com.example.crud.repository;

import com.example.crud.model.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MobileRepository extends JpaRepository<Mobile, Long> {}
