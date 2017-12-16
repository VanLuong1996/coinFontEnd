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
import org.springframework.transaction.annotation.Transactional;

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
    public ServicesDTO saveServices(ServicesDTO servicesDTO) {
        ServicesDTO response = new ServicesDTO();
        try {
            Services services = ModelMapperUtil.map(servicesDTO, Services.class);
            services = servicesRepository.save(services);
            response = ModelMapperUtil.map(services, ServicesDTO.class);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return response;
    }

    @Override
    public ServicesDTO findById(Long id) {
        ServicesDTO response = new ServicesDTO();
        try {
            Services services = servicesRepository.findById(id);
            response = ModelMapperUtil.map(services, ServicesDTO.class);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return response;
    }

    @Override
    @Transactional
    public boolean deleteById(ServicesDTO servicesDTO) {
        boolean response = false;
        try {
            servicesRepository.deleteServicesById(servicesDTO.getId());
            response = true;
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return response;
    }

    @Override
    public ServicesDTO updateServices(Long id, ServicesDTO servicesDTO) {
        ServicesDTO resDTO = new ServicesDTO();
        try {
            Services services = servicesRepository.findOne(id);
            services = ModelMapperUtil.map(servicesDTO, Services.class);
            services.setId(id);
            Services resEntity = servicesRepository.save(services);
            resDTO = ModelMapperUtil.map(resEntity, ServicesDTO.class);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return resDTO;
    }

    //mua mot hoac nhieu dich vu, tru coin dua vao ti gia giua tien va coin , luu transaction_log

    @Override
    public boolean transactionByServices(List<Long> lstServivesId, Long userId, String price, String quantiy) {
        //TODO -- get coins from smartcontact
        //luong coin hien tai cua user
        double userCoin = 0;
        userCoin = 100.0d;

        //tong luong coin ung voi service
        double totalCoinsOfService = 0;
        List<Services> lstService = new ArrayList<>();
        for (Long itemServiceId : lstServivesId) {
            Services servicesDTO = servicesRepository.findById(itemServiceId);
//            servicesDTO.
        }

        return false;
    }
}
