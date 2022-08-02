package com.storm.goodreads.services;

import com.storm.goodreads.dtos.AccountCreationRequest;
import com.storm.goodreads.dtos.UserDto;
import com.storm.goodreads.exceptions.GoodReadsException;

public interface UserService {
    UserDto createUserAccount(AccountCreationRequest accountCreationRequest) throws GoodReadsException;
}
