package com.storm.goodreads.services;


import com.storm.goodreads.dtos.AccountCreationRequest;
import com.storm.goodreads.dtos.UserDto;
import com.storm.goodreads.exceptions.GoodReadsException;
import com.storm.goodreads.models.User;
import com.storm.goodreads.repositories.UserRepository;
import com.storm.goodreads.utils.AccountValidation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        modelMapper = new ModelMapper();
    }
    @Override
    public UserDto createUserAccount(AccountCreationRequest accountCreationRequest) throws GoodReadsException {
        AccountValidation.validate(accountCreationRequest);
        User user = User.builder()
                .firstname(accountCreationRequest.getFirstName())
                .lastname(accountCreationRequest.getLastName())
                .email(accountCreationRequest.getEmail())
                .password(accountCreationRequest.getPassword())
                .build();
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDto.class);
    }

}
