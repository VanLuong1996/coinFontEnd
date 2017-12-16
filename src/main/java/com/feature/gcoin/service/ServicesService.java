package com.feature.gcoin.service;

import com.feature.gcoin.dto.ServiceDTO;
import com.feature.gcoin.model.Services;

import java.util.List;

public interface ServicesService {

    List<ServiceDTO> findAll();

    ServiceDTO findById(Long id);

    boolean deleteById(Long id);

    boolean deleteServicesById(Long id);

    ServiceDTO addServiceDTO(ServiceDTO serviceDTO);
}
