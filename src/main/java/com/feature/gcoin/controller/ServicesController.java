package com.feature.gcoin.controller;

import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/services", produces = MediaType.APPLICATION_JSON_VALUE)
public class ServicesController {
    @Autowired
    private ServicesService servicesService;

    @RequestMapping(method = GET, value = "/list")
    public ResponseEntity<?> findAllServices() {
        List<ServicesDTO> lst = servicesService.findAll();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", lst));
    }
    @RequestMapping(method = POST, value = "/add")
    public ResponseEntity<?> findAllServices() {
        List<ServicesDTO> lst = servicesService.findAll();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", lst));
    }


}