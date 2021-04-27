package com.cash.service;

import com.cash.model.User;

public interface UserService {

    User getUser();
    void edit(User newUser);

}
