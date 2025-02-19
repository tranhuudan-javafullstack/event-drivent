package com.tanthanh.borrowingservice.command.api.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tanthanh.borrowingservice.command.api.data.BorrowRepository;
import com.tanthanh.borrowingservice.command.api.model.Message;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
public class BorrowService implements IBorrowService {

    private final BorrowRepository repository;

    private final MessageChannel output;

    public BorrowService(BorrowRepository repository, MessageChannel output) {
        this.repository = repository;
        this.output = output;
    }

    @Override
    public void sendMessage(Message message) {
        try {

            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);
            output.send(MessageBuilder.withPayload(json).build());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public String findIdBorrowing(String employeeId, String bookId) {

        return repository.findByEmployeeIdAndBookIdAndReturnDateIsNull(employeeId, bookId).getId();
    }

}
