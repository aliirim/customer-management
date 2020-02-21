package com.techpeak.customermanagement.service.Impl;

import com.techpeak.customermanagement.Util.TPage;
import com.techpeak.customermanagement.dto.RegistrationDto;
import com.techpeak.customermanagement.dto.UserDto;
import com.techpeak.customermanagement.entity.Users;
import com.techpeak.customermanagement.repository.UserRepository;
import com.techpeak.customermanagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    ModelMapper modelMapper;
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDto save(UserDto userDto) {
        Users users = modelMapper.map(userDto, Users.class);
        users = userRepository.save(users);
        userDto.setId(users.getId());
        return userDto;
    }

    @Override
    public UserDto update(int id, UserDto userDto) {
        Users users = userRepository.getOne(userDto.getId());

        if (users == null) {
            throw new IllegalArgumentException("User Does Not Exist ID:" + id);
        }
        users.setName(userDto.getName());
        users.setSurname(userDto.getSurname());
        return modelMapper.map(users, UserDto.class);
    }

    @Override
    public UserDto getById(int id) {
        Users users = userRepository.getOne(id);
        return modelMapper.map(users, UserDto.class);
    }

    @Override
    public UserDto getByUserName(String name) {
        Users users = userRepository.findByName(name);
        return modelMapper.map(users, UserDto.class);
    }

    @Override
    public Boolean deleteById(int id) {
        userRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public TPage<UserDto> findAllPages(Pageable pageable) {
        Page<Users> users = userRepository.findAll(pageable);
        TPage<UserDto> userDtoTPage = new TPage<UserDto>();
        userDtoTPage.setPage(users, Arrays.asList(modelMapper.map(users.getContent(), UserDto[].class)));
        return userDtoTPage;
    }

    @Override
    public List<UserDto> getAll() {
        List<Users> users = userRepository.findAll();
        return Arrays.asList(modelMapper.map(users, UserDto[].class));
    }

    @Transactional
    public Boolean register(RegistrationDto registrationDto) {
        Users users = new Users();

        users.setName(registrationDto.getName());
        users.setSurname(registrationDto.getSurname());
        users.setPassword(registrationDto.getPassword());
        users.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
        users.setUserAccessCode(registrationDto.getUserAccessCode());
        users.setAuthorizationCode(registrationDto.getAuthorizationCode());
        users.setRegisterDate(registrationDto.getRegisterDate());
        users.setUsername(registrationDto.getUsername());
        userRepository.save(users);
        return Boolean.TRUE;
    }
}
