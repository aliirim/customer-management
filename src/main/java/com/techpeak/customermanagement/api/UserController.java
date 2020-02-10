package com.techpeak.customermanagement.api;

import com.techpeak.customermanagement.Util.ApiPaths;
import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.UserDto;
import com.techpeak.customermanagement.service.Impl.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.UserCtrl.CTRL)
@Api(value = ApiPaths.UserCtrl.CTRL)
public class UserController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UserDto.class)
    ResponseEntity<UserDto> getById(@PathVariable(value = "id") int id){
        UserDto userDto = userServiceImpl.getById(id);
        return ResponseEntity.ok(userDto);
    }

   /* @GetMapping("/{name}")
    @ApiOperation(value = "Get By Name Operation", response = UserDto.class)
    ResponseEntity<UserDto> getByUsername(@PathVariable(value = "name") String name){
        UserDto userDto = userServiceImpl.getByUserName(name);
        return ResponseEntity.ok(userDto);
    }*/

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = UserDto.class)
    ResponseEntity<TPage<UserDto>> getAllByPagination(Pageable pageable){
        TPage<UserDto> userDtoTPage = userServiceImpl.findAllPages(pageable);
        return ResponseEntity.ok(userDtoTPage);
    }

    @GetMapping
    @ApiOperation(value = "Get All By Operation", response = UserDto.class)
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> userDtos = userServiceImpl.getAll();
        return ResponseEntity.ok(userDtos);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = UserDto.class)
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user) {
        return ResponseEntity.ok(userServiceImpl.save(user));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = UserDto.class)
    public ResponseEntity<UserDto> updateUser(@PathVariable int id, @RequestBody UserDto user) {
        return ResponseEntity.ok(userServiceImpl.update(id, user));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = UserDto.class)
    ResponseEntity<Boolean> deleteById(@PathVariable(value = "id") int id){
        return ResponseEntity.ok(userServiceImpl.deleteById(id));
    }

}
