package com.feature.gcoin.service.impl;

import com.feature.gcoin.common.exception.BusinessException;
import com.feature.gcoin.common.exception.ExceptionCode;
import com.feature.gcoin.common.util.Constants;
import com.feature.gcoin.common.util.ModelMapperUtil;
import com.feature.gcoin.common.util.Utils;
import com.feature.gcoin.dto.UserDTO;
import com.feature.gcoin.dto.reponse.UserLoginResponse;
import com.feature.gcoin.dto.request.LoginRequest;
import com.feature.gcoin.model.User;
import com.feature.gcoin.service.AuthenticationService;
import com.feature.gcoin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Date;

/**
 * @author TienNV
 * @CreatedDate Oct 9, 2017 2:11:09 PM
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService
{
    @Autowired
    private UserService userService;

    @Override
    public UserLoginResponse authenticate(LoginRequest loginRequest, HttpServletRequest request) throws BusinessException
    {
        String userName = loginRequest.getUsername();
        String password = loginRequest.getPassword();
        String clientIp = request.getRemoteAddr();
        if ("".equals(userName) || "".equals(password))
        {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID, "UserName or Password invalid. please check again!", new Throwable(""));
        }

        User userEntity = userService.findByUsername(loginRequest.getUsername());
        if (userEntity == null)
        {
            throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID, "UserName or Password invalid. please check again!", new Throwable(""));
        }

        boolean isAuthen = userService.login(loginRequest);
        if (isAuthen)
        {
            UserLoginResponse response = new UserLoginResponse();
            response.setUserName(userName);
            response.setUserDTO(ModelMapperUtil.map(userEntity, UserDTO.class));
            return response;
        }
        throw new BusinessException(ExceptionCode.Authentication.AUTHENTICATION_USER_PASSWORD_INVALID, "UserName or Password invalid. please check again!", new Throwable());
    }
}