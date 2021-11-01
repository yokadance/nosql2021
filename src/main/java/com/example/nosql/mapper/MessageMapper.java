package com.example.nosql.mapper;

import com.example.nosql.dto.messages.request.CreateMessageDto;
import com.example.nosql.dto.messages.response.ReadMessageDto;
import com.example.nosql.model.Message;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface MessageMapper {
    Message createMessageDtoToMessage(CreateMessageDto createMessageDto);
    ReadMessageDto messageToReadMessageDto(Message message);
}
