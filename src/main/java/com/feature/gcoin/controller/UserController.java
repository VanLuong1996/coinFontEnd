package com.feature.gcoin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.math.BigInteger;
import java.security.Principal;
import java.util.List;

import com.feature.gcoin.dto.reponse.InformationUser;
import com.feature.gcoin.security.TokenHelper;
import com.feature.gcoin.service.GcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping( value = "/user", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionLogService transactionLogService;

    @Autowired
    private TokenHelper tokenHelper;

//    @Autowired
//    private GcoinService gcoinService;

    @RequestMapping( method = GET, value = "/{userId}" )
    public User loadById( @PathVariable Long userId ) {
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/all")
    public List<User> loadAll() {
        return this.userService.findAll();
    }
    
    @RequestMapping( method = RequestMethod.POST, value= "/user/transferCoin")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<Response> transferCoin(@RequestBody UserRequest req) throws GcoinException {
    	try {
    		TransactionLog result = transactionLogService.insert(req, Constants.TransactionType.TRANSFER_COIN.name());
    		Response response = new Response(Constants.ResponseCode.OK.getValue(), Constants.ResponseCode.OK.getDisplay(), result);
    		return ResponseEntity.ok(response);
    		
    	}catch(Exception ex) {
    		throw new GcoinException(Constants.ExceptionCode.Unknown.getValue(), ex.toString());
    	}
    }
    
    @RequestMapping( method = RequestMethod.POST, value= "/user/addCoin")
    public ResponseEntity<Response> addCoin(@RequestBody UserRequest req) throws GcoinException {
    	try {
    		TransactionLog result = transactionLogService.insert(req, Constants.TransactionType.ADD_COIN.name());
    		Response response = new Response(Constants.ResponseCode.OK.getValue(), Constants.ResponseCode.OK.getDisplay(), result);
    		return ResponseEntity.ok(response);
    		
    	}catch(Exception ex) {
    		throw new GcoinException(Constants.ExceptionCode.Unknown.getValue(), ex.toString());
    	}
    }
    
    @RequestMapping( method = RequestMethod.POST, value= "/user/subtractCoin")
    public ResponseEntity<Response>  subtractCoin(@RequestBody UserRequest req) throws GcoinException {
    	try {
    		TransactionLog result = transactionLogService.insert(req, Constants.TransactionType.SUBTRACTION_COIN.name());
    		Response response = new Response(Constants.ResponseCode.OK.getValue(), Constants.ResponseCode.OK.getDisplay(), result);
    		return ResponseEntity.ok(response);
    		
    	}catch(Exception ex) {
    		throw new GcoinException(Constants.ExceptionCode.Unknown.getValue(), ex.toString());
    	}
    }

    @RequestMapping(value = "/info", method = GET)
    public InformationUser loadInformationUser(HttpServletRequest req) {
        String token = tokenHelper.getToken(req);
        String username = tokenHelper.getUsernameFromToken(token);

        InformationUser informationUser = new InformationUser();
        User user = userService.findByUsername( username );
        informationUser.setEmail(user.getEmail());
        informationUser.setName(user.getName());
        informationUser.setUserName(user.getUsername());
        informationUser.setNumberCoin(BigInteger.valueOf(10));
//        informationUser.setNumberCoin(user.getAddress().toString());
        return informationUser;
    }

//    @RequestMapping(value = "/update/{id}", method = POST)
//    public ResponseEntity<Response> update
}
