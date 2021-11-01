package com.example.demo.mapper;

import com.example.demo.dto.messages.request.CreateMessageDto;
import com.example.demo.dto.messages.response.ReadMessageDto;
import com.example.demo.model.Message;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MessageMapper {
    Message createMessageDtoToMessage(CreateMessageDto createMessageDto);
    ReadMessageDto messageToReadMessageDto(Message message);
}
