package com.twopro.deliveryapp.user.dto;

import com.twopro.deliveryapp.user.entity.User;
import lombok.Getter;
import lombok.Setter;

// user 공통 필드 dto
@Getter
@Setter
public class UserDto {
    private Long userId;
    private String email;
    private String nickname;

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.nickname = user.getNickname();
    }
}
