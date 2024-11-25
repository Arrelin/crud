package com.example.crud.controller;

import com.example.crud.dto.MobileDTO;
import com.example.crud.dto.MobileUpdateDTO;
import com.example.crud.service.MobileServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mobile")
@RequiredArgsConstructor
public class MobileController {

    private final MobileServiceImpl mobileServiceImpl;

    // Probably liquibase will cause errors on first creation because of its stupidity. Better use flyway thou
    /** <p>Takes your params(excluding id and date) to add new Mobile Entity in to Database</p>
     *
     * @param mobileDTO
     * String manufacturer,ram,memory,battery,processor
     * BigDecimal price
     * @return Mobile
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MobileDTO> createMobile(@RequestBody MobileDTO mobileDTO) {
        return ResponseEntity.ok(mobileServiceImpl.createMobile(mobileDTO));
    }

    /**
     * <p> Searches Mobiles by ID and return it on success</p>
     * @param id
     * @return MoBile
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MobileDTO> getMobileById(@PathVariable Long id) {
        return ResponseEntity.ok(mobileServiceImpl.getMobileById(id));
    }

    /**
     *  <p>Get all Mobiles from DB on path "api/mobile" or "api/mobile/" for Postman, not for real use</p>
     * @return List of Mobile
     */
    @GetMapping(value = {"/", ""})
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<MobileDTO>> getAllMobiles() {
        return ResponseEntity.ok(mobileServiceImpl.getAllMobiles());
    }

    /** <p>Takes your params, keeping the unchanged ones to update
     * the Entity from DB</p>
     *
     * @param id
     * @param mobileUpdateDTO
     * @return updated Mobile Entity
     */
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<MobileDTO> updateMobile(@PathVariable Long id, @RequestBody MobileUpdateDTO mobileUpdateDTO) {
        return ResponseEntity.ok(mobileServiceImpl.updateMobile(id, mobileUpdateDTO));
    }

    /**
     * <p>Just delete the entity by its ID</p>
     * @param id
     * @return 200 OK
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Void> deleteMobile(@PathVariable Long id) {
        mobileServiceImpl.deleteMobile(id);
        return ResponseEntity.ok().build();
    }

}
