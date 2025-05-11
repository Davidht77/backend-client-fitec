package com.example.cloudproject.Client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserValidationResponse {
    private UUID userId;
    private String email;
    private String hashedPassword;
    private List<String> roles = new ArrayList<>();
}
