package com.twopro.deliveryapp.order.excepiton;

import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException{

    private Long userId;

    public UserNotFoundException(String message, Long userId) {
        super(message);
        this.userId = userId;
    }




}
