package com.feature.gcoin.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.security.Principal;
import java.util.List;

import com.feature.gcoin.dto.reponse.InformationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feature.gcoin.model.User;
import com.feature.gcoin.service.UserService;


@RestController
@RequestMapping( value = "/api", produces = MediaType.APPLICATION_JSON_VALUE )
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping( method = GET, value = "/user/{userId}" )
    public User loadById( @PathVariable Long userId ) {
        return this.userService.findById( userId );
    }

    @RequestMapping( method = GET, value= "/user/all")
    public List<User> loadAll() {
        return this.userService.findAll();
    }

    @RequestMapping(value = "/get-infor", method = GET)
    public InformationUser loadInforById( @PathVariable Long userId ) {
        InformationUser informationUser = new InformationUser();
        User user = userService.findById( userId );
        informationUser.setEmail(user.getEmail());
        informationUser.setName(user.getName());
        informationUser.setUserName(user.getUsername());
        informationUser.setAddress(user.getAddress());
        return informationUser;
    }
}
