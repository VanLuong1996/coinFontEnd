package com.feature.gcoin.controller;

import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.model.User;
import com.feature.gcoin.service.ServicesService;
import com.feature.gcoin.service.UserService;
import com.feature.gcoin.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping( value = "/votes", produces = MediaType.APPLICATION_JSON_VALUE )
public class VoteController {
    @Autowired
    private VoteService voteService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = GET, value = "/bestStaffs")
    public ResponseEntity<?> bestStaffs() {
        List<User> lst = userService.findAll();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", lst));
    }
    @RequestMapping(method = POST, value = "/bestStaffsVotes")
    public ResponseEntity<?> bestStaffsVotes() {
        List<User> lst = userService.findAll();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", lst));
    }

    @RequestMapping(method = POST, value = "/addBestStaff")
    public ResponseEntity<?> bestStaffsVotes() {
        List<User> lst = userService.findAll();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", lst));
    }
    @RequestMapping(method = GET, value = "/getstatusVoter")
    public ResponseEntity<?> getstatusVoter(HttpServletRequest req) {
        Long numberOfVote = voteService.getNumberOfVote();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", numberOfVote));
    }


}
