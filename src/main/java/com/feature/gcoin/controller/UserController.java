package com.feature.gcoin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.math.BigInteger;
import java.util.List;

import com.feature.gcoin.dto.reponse.InformationUser;
import com.feature.gcoin.security.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<Response> transferCoin(@RequestBody UserRequest req, HttpServletRequest httpServletRequest) throws GcoinException {
        try {
            String token = tokenHelper.getToken(httpServletRequest);
            String username = tokenHelper.getUsernameFromToken(token);
            User user = userService.findByUsername(username);
            TransactionLog result = transactionLogService.insert(user.getId(), req, Constants.TransactionType.TRANSFER_COIN.name());
            Response response = new Response(Constants.ResponseCode.OK.getValue(), Constants.ResponseCode.OK.getDisplay(), result);
            return ResponseEntity.ok(response);

        } catch (Exception ex) {
            throw new GcoinException(Constants.ExceptionCode.Unknown.getValue(), ex.toString());
        }
    }

    @RequestMapping(value = "/getCoins", method = GET)
    public InformationUser getCoins(HttpServletRequest req) {
        String token = tokenHelper.getToken(req);
        String username = tokenHelper.getUsernameFromToken(token);

        InformationUser informationUser = new InformationUser();
        User user = userService.findByUsername(username);
        informationUser.setEmail(user.getEmail());
        informationUser.setAddress(user.getAddress());
        informationUser.setName(user.getName());
        informationUser.setUserName(user.getUsername());
        informationUser.setNumberCoin(BigInteger.valueOf(10));
        informationUser.setPriceCoin(BigInteger.valueOf(10000));
        return informationUser;
    }

//    @RequestMapping(value = "/update/{id}", method = POST)
//    public ResponseEntity<Response> update
}
