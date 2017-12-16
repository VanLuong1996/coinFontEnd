package com.feature.gcoin.controller;

import com.feature.gcoin.common.DeviceProvider;
import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.model.User;
import com.feature.gcoin.security.TokenHelper;
import com.feature.gcoin.service.CheckInOutService;
import com.feature.gcoin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/checkInOut")
public class CheckInCheckOutConTroller {

    //lay thong tin nguoi dung va thiet bi
    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    private DeviceProvider deviceProvider;

    @Autowired
    private CheckInOutService checkInOutService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST) //post
    public ResponseEntity<?> timekeeping(HttpServletRequest req) throws Exception {

        String token = tokenHelper.getToken(req);
        String username = tokenHelper.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        boolean firstCheck = checkInOutService.isTheFistCheckInOut(user.getId());
        if (firstCheck) {
            checkInOutService.updateInforCheckInOut(user.getId());
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "Check In Successful", null));
        } else {
            checkInOutService.updateInforCheckInOut(user.getId());
            return ResponseEntity.ok(new Response(Constants.SUCCESS, "Check Out Successful", null));
        }
    }
}
