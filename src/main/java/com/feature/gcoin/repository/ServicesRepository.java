package com.feature.gcoin.repository;

import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.model.Services;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {

    List<Services> findAll();

    ServicesDTO findById(Long id);

    boolean deleteById(Long id);

    boolean deleteServicesById(Long id);

//    ServicesDTO addServiceDTO(ServicesDTO servicesDTO);
}
