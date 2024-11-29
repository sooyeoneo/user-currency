package com.example.usercurrency.dto;

import com.example.usercurrency.entity.User;
import lombok.Getter;

@Getter
public class UserResDto {

    private Long id;

    private String email;
    private String name;

    public UserResDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
    }

    public UserResDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public static UserResDto toDto(User user) {
        return new UserResDto(
                user.getId(),
                user.getEmail(),
                user.getName()
        );
    }
}
