package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.model.Services;
import com.feature.gcoin.repository.ServicesRepository;
import com.feature.gcoin.service.ServicesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    private final Logger log = LoggerFactory.getLogger(ServicesServiceImpl.class);

    @Autowired
    private ServicesRepository servicesRepository;

    @Override
    public List<ServicesDTO> findAll() {
        List<ServicesDTO> servicesDTOS = new ArrayList<>();
        try {
            List<Services> services = servicesRepository.findAll();
            servicesDTOS = ModelMapperUtil.maps((List) services, ServicesDTO.class);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return servicesDTOS;
    }

    @Override
    public ServicesDTO findById(Long id) {
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
    public ServicesDTO addServiceDTO(ServicesDTO servicesDTO) {
        return null;
    }
}
