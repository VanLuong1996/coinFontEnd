package com.feature.gcoin.service.impl;

import com.feature.gcoin.dto.ServiceDTO;
import com.feature.gcoin.model.Services;
import com.feature.gcoin.repository.ServicesRepository;
import com.feature.gcoin.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServicesServiceImpl implements ServicesService {
    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<ServiceDTO> findAll() {
        List<Services> services = servicesRepository.findAll();
        return servicesRepository.findAll();

    }

    @Override
    public ServiceDTO findById(Long id) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean deleteServicesById(Long id) {
        return false;
    }

    @Override
    public ServiceDTO addServiceDTO(ServiceDTO serviceDTO) {
        return null;
    }
}
