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

    @RequestMapping(value = "/timekeeping", method = RequestMethod.POST) //post
    public ResponseEntity<?> timekeeping(@RequestBody CheckInOutRequest checkInOutRequest){
        Boolean firstCheck = checkInOutService.isTheFistCheckInOut(checkInOutRequest.getUserId());
        if(firstCheck == true) {
            checkInOutService.updateInforCheckInOut(checkInOutRequest.getUserId());
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "In Successful", null));
        }else {
            checkInOutService.updateInforCheckInOut(checkInOutRequest.getUserId());
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "Out Successful", null));
        }
    }
}
