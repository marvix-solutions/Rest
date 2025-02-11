package com.restapi.bookrestapi.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min = 4, message = "User must be min of 4 charactors")
    private String name;
    @Email(message = "Email address is not valid")
    private String email;
    @NotEmpty()
    @Size(min = 3, max = 10, message = "Password must be less then 10 and greater then 3")
    private String password;
    @NotEmpty
    private String about;
}
