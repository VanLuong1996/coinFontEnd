package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.constant.Const;
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

import java.math.BigInteger;
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

    public void tranferMoneyToCoin(Long userMoney) {

    }

    //mua mot hoac nhieu dich vu, tru coin dua vao ti gia giua tien va coin mat di , luu transaction_log
    @Override
    public void transactionByServices(Long userId, List<ServicesDTO> lstServives) {
        try { //TODO -- get coins from smartcontact
            //luong coin hien tai cua user
            BigInteger userCoin;
            userCoin = BigInteger.valueOf(1000);

            //tong luong coin ung voi service
            BigInteger totalCoinsOfService;
            Long temp = null;
            for (ServicesDTO services : lstServives) {
                temp = +(Long) Long.valueOf(services.getPrice()) * services.getTotal() * Const.exchangeRate.longValue();
            }
            totalCoinsOfService = BigInteger.valueOf(temp);
            if (userCoin.compareTo(totalCoinsOfService) < 0) {
                throw new Exception("Tai khoan cua user khong du de thuc hien giao dich");
            } else {
                // TODO -- minus coins from smartcontract
                userCoin = userCoin.subtract(totalCoinsOfService);
                log.info("Coin hien tai cua user: " + userCoin);
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }

    @Override
    public List<ServicesDTO> listOwnedServices(Long userId) {
        //TODO
        List<ServicesDTO> servicesDTOS = new ArrayList<>();
        List<Services> services = servicesRepository.findAll();
        servicesDTOS = ModelMapperUtil.maps((List) services, ServicesDTO.class);
        return servicesDTOS;
    }

}
