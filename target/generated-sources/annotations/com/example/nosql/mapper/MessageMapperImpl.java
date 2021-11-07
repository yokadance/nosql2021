package com.example.nosql.mapper;

import com.example.nosql.dto.messages.request.CreateMessageDto;
import com.example.nosql.dto.messages.response.ReadMessageDto;
import com.example.nosql.model.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-06T23:49:01-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Ubuntu)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message createMessageDtoToMessage(CreateMessageDto createMessageDto) {
        if ( createMessageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setErrorCode( createMessageDto.getErrorCode() );
        message.setMessage( createMessageDto.getMessage() );

        return message;
    }

    @Override
    public ReadMessageDto messageToReadMessageDto(Message message) {
        if ( message == null ) {
            return null;
        }

        ReadMessageDto readMessageDto = new ReadMessageDto();

        readMessageDto.setErrorCode( message.getErrorCode() );
        readMessageDto.setMessage( message.getMessage() );

        return readMessageDto;
    }
}
