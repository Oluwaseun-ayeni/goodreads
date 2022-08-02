package com.storm.goodreads.utils;

import com.storm.goodreads.dtos.AccountCreationRequest;
import com.storm.goodreads.exceptions.GoodReadsException;
import com.storm.goodreads.models.User;
import com.storm.goodreads.repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class AccountValidation {
    private static UserRepository userRepository;

    public AccountValidation(UserRepository userRepository) {
        AccountValidation.userRepository = userRepository;
    }

    public static void validate(AccountCreationRequest accountCreationRequest) throws GoodReadsException {
        User user = userRepository.findUserByEmail(accountCreationRequest.getEmail()).orElse(null);
        if (user != null){
            throw new GoodReadsException("user email already exists");
        }
    }
}
