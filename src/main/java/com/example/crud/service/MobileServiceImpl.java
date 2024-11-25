package com.example.crud.service;

import com.example.crud.dto.MobileDTO;
import com.example.crud.dto.MobileUpdateDTO;
import com.example.crud.model.Mobile;
import com.example.crud.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MobileServiceImpl implements MobileService {

    private final MobileRepository mobileRepository;


    /** <p>Takes your params for making Mobile</p>
     * <p>Takes Date as of creation</p>
     *
     * @param mobileDTO
     * @return Mobile Entity
     */
    @Override
    public MobileDTO createMobile(MobileDTO mobileDTO) {
        Mobile mobile = Mobile.builder()
                .manufacturer(mobileDTO.manufacturer())
                .ram(mobileDTO.ram())
                .memory(mobileDTO.memory())
                .battery(mobileDTO.battery())
                .processor(mobileDTO.processor())
                .price(mobileDTO.price())
                .createdAt(LocalDate.now())
                .build();
        mobileRepository.save(mobile);
        log.info("Mobile created: {}", mobile);
        return mobileDTO;
    }

    @Override
    public MobileDTO getMobileById(Long id) {
        Mobile mobile = mobileRepository.findById(id).orElseThrow(() -> new RuntimeException("Mobile not found"));
        return new MobileDTO(mobile.getId(), mobile.getManufacturer(), mobile.getRam(), mobile.getMemory(), mobile.getBattery(), mobile.getProcessor(), mobile.getPrice(), mobile.getCreatedAt());
    }

    @Override
    public List<MobileDTO> getAllMobiles() {
        return mobileRepository.findAll().stream()
                .map(mobile -> new MobileDTO(
                        mobile.getId(),
                        mobile.getManufacturer(),
                        mobile.getRam(),
                        mobile.getMemory(),
                        mobile.getBattery(),
                        mobile.getProcessor(),
                        mobile.getPrice(),
                        mobile.getCreatedAt()))
                .toList();
    }


    /**
     * <p>Checks values what wanna be updated in DTO and pushes changes to the db</p>
     *
     *
     * @param id
     * @param mobileUpdateDTO
     * @return MobileDTO
     */
    @Override
    public MobileDTO updateMobile(Long id, MobileUpdateDTO mobileUpdateDTO) {
        Mobile mobile = mobileRepository.findById(id).orElseThrow(() -> new RuntimeException("Mobile not found"));

        if (mobileUpdateDTO.manufacturer() != null) {
            mobile.setManufacturer(mobileUpdateDTO.manufacturer());
        }
        if (mobileUpdateDTO.ram() != null) {
            mobile.setRam(mobileUpdateDTO.ram());
        }
        if (mobileUpdateDTO.memory() != null) {
            mobile.setMemory(mobileUpdateDTO.memory());
        }
        if (mobileUpdateDTO.battery() != null) {
            mobile.setBattery(mobileUpdateDTO.battery());
        }
        if (mobileUpdateDTO.processor() != null) {
            mobile.setProcessor(mobileUpdateDTO.processor());
        }
        if (mobileUpdateDTO.price() != null) {
            mobile.setPrice(mobileUpdateDTO.price());
        }

        mobileRepository.save(mobile);

        return new MobileDTO(mobile.getId(), mobile.getManufacturer(), mobile.getRam(), mobile.getMemory(), mobile.getBattery(), mobile.getProcessor(), mobile.getPrice(), mobile.getCreatedAt());
    }

    @Override
    public void deleteMobile(Long id) {
        mobileRepository.deleteById(id);
    }
}
