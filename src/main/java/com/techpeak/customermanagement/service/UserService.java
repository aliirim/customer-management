package com.techpeak.customermanagement.service;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.UserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    public UserDto save(UserDto userDto);

    public UserDto update(int id, UserDto userDto);

    public UserDto getById(int id);

    public UserDto getByUserName(String name);

    public Boolean deleteById(int id);

    public TPage<UserDto> findAllPages(Pageable pageable);

    public List<UserDto> getAll();
}
