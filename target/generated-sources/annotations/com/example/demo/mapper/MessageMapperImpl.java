package com.example.demo.mapper;

import com.example.demo.dto.messages.request.CreateMessageDto;
import com.example.demo.dto.messages.response.ReadMessageDto;
import com.example.demo.model.Message;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-29T13:15:57-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.10 (Oracle Corporation)"
)
@Component
public class MessageMapperImpl implements MessageMapper {

    @Override
    public Message createMessageDtoToMessage(CreateMessageDto createMessageDto) {
        if ( createMessageDto == null ) {
            return null;
        }

        Message message = new Message();

        message.setId( createMessageDto.getId() );
        message.setMessage( createMessageDto.getMessage() );

        return message;
    }

    @Override
    public ReadMessageDto messageToReadMessageDto(Message message) {
        if ( message == null ) {
            return null;
        }

        ReadMessageDto readMessageDto = new ReadMessageDto();

        readMessageDto.setId( message.getId() );
        readMessageDto.setMessage( message.getMessage() );

        return readMessageDto;
    }
}
