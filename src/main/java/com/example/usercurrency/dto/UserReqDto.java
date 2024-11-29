package com.example.usercurrency.dto;

import com.example.usercurrency.entity.User;
import lombok.Getter;

@Getter
public class UserReqDto {

    private String email;
    private String name;

    public User toEntity() {
        return new User(
                this.email,
                this.name
        );
    }
}
