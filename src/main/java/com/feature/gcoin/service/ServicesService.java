package com.feature.gcoin.service;

import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.model.Services;

import java.util.List;

public interface ServicesService {

    List<ServicesDTO> findAll();

    ServicesDTO saveServices(ServicesDTO servicesDTO);

    ServicesDTO findById(Long id);

    boolean deleteById(ServicesDTO servicesDTO);

    ServicesDTO updateServices(Long id, ServicesDTO servicesDTO);
}
