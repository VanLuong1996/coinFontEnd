package com.feature.gcoin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
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


@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private TransactionLogService transactionLogService;

    @RequestMapping( method = GET, value = "/user/{userId}" )
    public User loadById( @PathVariable Long userId ) {
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/user/all")
    public List<User> loadAll() {
        return this.userService.findAll();
    }
    
    @RequestMapping( method = RequestMethod.POST, value= "/user/transferCoin")
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

}
