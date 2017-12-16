package com.feature.gcoin.controller;

import com.feature.gcoin.common.DeviceProvider;
import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.dto.request.CheckInOutRequest;
import com.feature.gcoin.security.TokenHelper;
import com.feature.gcoin.service.CheckInOutService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class CheckInCheckOutConTroller {

    //lay thong tin nguoi dung va thiet bi
    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private DeviceProvider deviceProvider;

    @Autowired
    private CheckInOutService checkInOutService;

    @RequestMapping(value = "/check-in-out", method = RequestMethod.POST) //post
    //@PreAuthorize("hasRole('USER')") //quyen thuc hien: user
    public ResponseEntity<?> checkInOut(@RequestBody CheckInOutRequest checkInOutRequest){
        Boolean firstCheck = checkInOutService.isTheFistCheckInOut(checkInOutRequest.getUserId());
        if(firstCheck == true) {
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "Check In Successful", null));
        }else {
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "Check Out Successful", null));
        }
    }

}
