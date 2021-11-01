package com.example.demo.dto.messages.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReadMessageDto {

    private String errorCode;
    private String message;
}
