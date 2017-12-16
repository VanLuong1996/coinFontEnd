package com.feature.gcoin.service;

import com.feature.gcoin.dto.ServicesDTO;

import java.util.List;

public interface ServicesService {

    List<ServicesDTO> findAll();

    ServicesDTO findById(Long id);

    boolean deleteById(Long id);

    boolean deleteServicesById(Long id);

    ServicesDTO addServiceDTO(ServicesDTO servicesDTO);
}
