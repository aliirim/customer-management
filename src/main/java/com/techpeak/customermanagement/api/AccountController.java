package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.dto.RegistrationDto;
import com.techpeak.customermanagement.dto.UserDto;
import com.techpeak.customermanagement.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.RegisterCtrl.CTRL)
@Api(value = ApiPaths.RegisterCtrl.CTRL)
public class AccountController {

    UserServiceImpl userServiceImpl;

    public AccountController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping
    @ApiOperation(value = "Register Operation", response = RegistrationDto.class)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationDto registrationDto) {
        Boolean response = userServiceImpl.register(registrationDto);
        return ResponseEntity.ok(response);
    }

}
