package com.xworkz.userlogin.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class UserDTO {

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter a valid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank (required for login)")
    @Size(min = 6, max = 20, message = "Password must be 6–20 characters")
    private String password;

    @NotBlank(message = "Name is required for registration")
    @Size(min = 3, max = 30, message = "Name should be 3–30 characters")
    private String name;

    @Past(message = "Date of Birth must be in the past")
    private LocalDate dob;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be 10 digits")
    private String contactNumber;

    @Pattern(regexp = "Male|Female", message = "Gender must be Male or Female")
    private String gender;
}