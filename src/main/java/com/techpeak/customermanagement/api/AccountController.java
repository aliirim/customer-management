package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.dto.LoginRequest;
import com.techpeak.customermanagement.dto.RegistrationDto;
import com.techpeak.customermanagement.dto.TokenResponse;
import com.techpeak.customermanagement.entity.Users;
import com.techpeak.customermanagement.repository.UserRepository;
import com.techpeak.customermanagement.security.JwtTokenUtil;
import com.techpeak.customermanagement.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.TokenCtrl.CTRL)
@Api(value = ApiPaths.TokenCtrl.CTRL)
public class AccountController {

    UserServiceImpl userServiceImpl;
    AuthenticationManager authenticationManager;
    JwtTokenUtil jwtTokenUtil;
    UserRepository userRepository;

    @Autowired
    public AccountController(UserServiceImpl userServiceImpl, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil,  UserRepository userRepository) {
        this.userServiceImpl = userServiceImpl;
        this.authenticationManager =  authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    @ApiOperation(value = "Register Operation", response = RegistrationDto.class)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationDto registrationDto) {
        Boolean response = userServiceImpl.register(registrationDto);
        return ResponseEntity.ok(response);
    }


    @PostMapping
    @ApiOperation(value = "Login Operation", response = RegistrationDto.class)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final Users user = userRepository.findByUsername(request.getUsername());
        //final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUsername(),""));
    }


}
