package com.example.demo.dto.messages.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
public class CreateMessageDto {
    @NotBlank(message = "all fields must be contain data")
    private String errorCode;
    private String message;
}
