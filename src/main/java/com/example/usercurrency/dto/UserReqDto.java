package com.example.usercurrency.dto;

import com.example.usercurrency.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class UserReqDto {

    @NotNull(message = "이메일을 입력해주세요.")
    @Email(message = "올바른 이메일을 입력해주세요.")
    private String email;

    @NotNull(message = "이름을 입력해주세요.")
    @Size(min = 1, max = 50, message = "이름은 1자 이상, 50자 이하여야 합니다.")
    private String name;

    public User toEntity() {
        return new User(
                this.email,
                this.name
        );
    }
}
