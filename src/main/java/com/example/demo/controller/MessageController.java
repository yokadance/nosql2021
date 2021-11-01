package com.example.demo.controller;


import com.example.demo.dto.messages.request.CreateMessageDto;
import com.example.demo.dto.messages.response.ReadMessageDto;
import com.example.demo.model.UserContext;
import com.example.demo.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("messages")
@Validated
public class MessageController {

    @Resource(name= "requestUserDataContext")
    private UserContext userContext;

    private MessageService messageService;

    public MessageController(MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping
    @Operation(summary = "Este endpoint lista los mensajes")
    ResponseEntity<List<ReadMessageDto>> listMessages() {
        return ResponseEntity.ok(this.messageService.listMessages());
    }

    @PostMapping
    @Operation(summary = "Este endpoint crea y retorna un mensaje")
    ResponseEntity<ReadMessageDto> createMessage(@RequestBody @Valid CreateMessageDto createMessageDto){
        var persistedMessage = this.messageService.createMessage(createMessageDto);
        return ResponseEntity.ok(persistedMessage);
    }







}
