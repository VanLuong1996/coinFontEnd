package com.feature.gcoin.repository;

import com.feature.gcoin.dto.ServiceDTO;
import com.feature.gcoin.model.Services;
import com.feature.gcoin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Services, Long> {

    List<Services> findAll();

    ServiceDTO findById(Long id);

    boolean deleteById(Long id);

    boolean deleteServicesById(Long id);

    ServiceDTO addServiceDTO(ServiceDTO serviceDTO);
}
