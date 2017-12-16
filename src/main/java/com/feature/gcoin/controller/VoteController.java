package com.feature.gcoin.controller;

import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.dto.ServicesDTO;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.VoteDTO;
import com.feature.gcoin.dto.reponse.Response;
import com.feature.gcoin.dto.request.UserRequest;
import com.feature.gcoin.model.User;
import com.feature.gcoin.security.TokenHelper;
import com.feature.gcoin.service.ServicesService;
import com.feature.gcoin.service.UserService;
import com.feature.gcoin.service.VoteService;
import com.feature.gcoin.smartcontract.GemVote;
import com.feature.gcoin.util.GemVoteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.crypto.CipherException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/votes", produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    @Autowired
    private VoteService voteService;
    @Autowired
    private TokenHelper tokenHelper;
    @Autowired
    private UserService userService;

    @RequestMapping(method = GET, value = "/bestStaffs")
    public ResponseEntity<?> bestStaffs() throws Exception {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> lst = userService.findByIsFeature();
        for (User user : lst) {
            int votes = voteService.getNumberOfVote(user.getAddress());
            UserDTO userDTO = ModelMapperUtil.map(user, UserDTO.class);
            userDTO.setNumberVote(Math.toIntExact(votes));
            userDTOS.add(userDTO);
        }
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", userDTOS));
    }

    @RequestMapping(method = POST, value = "/voteToStaff/{idUser}")
    public ResponseEntity<?> voteToStaff(@PathVariable Long idUser, HttpServletRequest httpServletRequest) throws Exception {
        String token = tokenHelper.getToken(httpServletRequest);
        String username = tokenHelper.getUsernameFromToken(token);
        User user = userService.findByUsername(username);
        boolean res = voteService.voteToStaff(user.getAddress(), idUser);
        String msg = res ? "Have voted before!." : "Successful";
        return ResponseEntity.ok(new Response(Constants.SUCCESS, msg, res));
    }

//    @RequestMapping(method = POST, value = "/addBestStaff")
//    public ResponseEntity<?> addBestStaff(@RequestBody String address) {
//        boolean response = voteService.addBestStaff(address);
//        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", response));
//    }

//    @RequestMapping(method = GET, value = "/getstatusVoter/{address}")
//    public ResponseEntity<?> getstatusVoter(String address) {
//        Long numberOfVote = voteService.getNumberOfVote(address);
//        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", numberOfVote));
//    }

    @RequestMapping(method = POST, value = "/openSessionVote")
    public ResponseEntity<?> openSessionVote() throws Exception {
        boolean response = voteService.openSessionVote();
        return ResponseEntity.ok(new Response(Constants.SUCCESS, "Successful", response));
    }

}
