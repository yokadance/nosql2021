package com.example.nosql.service;

import com.example.nosql.dto.messages.request.CreateMessageDto;
import com.example.nosql.dto.messages.response.ReadMessageDto;
import com.example.nosql.mapper.MessageMapper;
import com.example.nosql.repository.MessageRepository;
import org.neo4j.annotations.service.Service;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Repository
public class MessageService {

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;


    public MessageService(MessageRepository messageRepository, MessageMapper messageMapper) {
        this.messageRepository = messageRepository;
        this.messageMapper = messageMapper;
    }

    public ReadMessageDto createMessage(CreateMessageDto createMessageDto){
        var a = this.messageMapper.createMessageDtoToMessage(createMessageDto);
        var b = this.messageRepository.save(a);
        return  this.messageMapper.messageToReadMessageDto(b);
    }

    public List<ReadMessageDto> listMessages(){
        var messages = this.messageRepository.findAll();
        return  messages.stream().map(this.messageMapper::messageToReadMessageDto).collect(Collectors.toList());
    }


}
