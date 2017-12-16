package com.feature.gcoin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.math.BigInteger;

import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.reponse.InformationUser;
import com.feature.gcoin.security.TokenHelper;
import com.feature.gcoin.service.CheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.feature.gcoin.common.constant.Constants;
import com.feature.gcoin.common.constant.GcoinException;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.TransactionLog;
import com.feature.gcoin.model.User;
import com.feature.gcoin.service.TransactionLogService;
import com.feature.gcoin.service.UserService;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransactionLogService transactionLogService;

    @Autowired
    private TokenHelper tokenHelper;

    @Autowired
    private CheckInOutService checkInOutService;

//    @Autowired
//    private GcoinService gcoinService;

    @RequestMapping(method = GET, value = "")
    public User loadById(HttpServletRequest req) {
        String token = tokenHelper.getToken(req);
        String username = tokenHelper.getUsernameFromToken(token);
        return userService.findByUsername(username);
    }

//    @RequestMapping(method = GET, value = "/all")
//    public List<User> loadAll() {
//        return this.userService.findAll();
//    }

    @RequestMapping(method = RequestMethod.POST, value = "/transferCoin")
//    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<?> transferCoin(@RequestBody UserRequest req, HttpServletRequest httpServletRequest) throws GcoinException {
        try {
            String token = tokenHelper.getToken(httpServletRequest);
            String username = tokenHelper.getUsernameFromToken(token);
            User user = userService.findByUsername(username);
            transactionLogService.insertTransfer(user.getId(), req);
            Response response = new Response(Constants.ResponseCode.OK.getValue(), Constants.ResponseCode.OK.getDisplay(), null);
            return ResponseEntity.ok(response);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new GcoinException(Constants.ExceptionCode.Unknown.getValue(), ex.toString());
        }
    }

    @RequestMapping(value = "/getCoins", method = GET)
    public UserDTO getCoins(HttpServletRequest req) {
        String token = tokenHelper.getToken(req);
        String username = tokenHelper.getUsernameFromToken(token);

        User user = userService.findByUsername(username);
        UserDTO userDTO = ModelMapperUtil.map(user, UserDTO.class);
        userDTO.setNumberVote(10000);
        userDTO.setNumberCoin(BigInteger.valueOf(10));
        userDTO.setPriceCoin(BigInteger.valueOf(10000));
        return userDTO;
    }


}
