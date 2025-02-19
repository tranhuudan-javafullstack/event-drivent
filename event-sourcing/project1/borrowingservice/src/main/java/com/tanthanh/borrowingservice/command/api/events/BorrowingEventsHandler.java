package com.tanthanh.borrowingservice.command.api.events;

import com.tanthanh.borrowingservice.command.api.data.BorrowRepository;
import com.tanthanh.borrowingservice.command.api.data.Borrowing;
import com.tanthanh.borrowingservice.command.api.model.Message;
import com.tanthanh.borrowingservice.command.api.service.IBorrowService;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BorrowingEventsHandler {

    private final BorrowRepository borrowRepository;

    private final IBorrowService borrowService;

    public BorrowingEventsHandler(BorrowRepository borrowRepository, IBorrowService borrowService) {
        this.borrowRepository = borrowRepository;
        this.borrowService = borrowService;
    }

    @EventHandler
    public void on(BorrowCreatedEvent event) {
        Borrowing model = new Borrowing();

        BeanUtils.copyProperties(event, model);

        borrowRepository.save(model);
    }

    @EventHandler
    public void on(BorrowDeletedEvent event) {
        if (borrowRepository.findById(event.getId()).isPresent()) {
            borrowRepository.deleteById(event.getId());
        } else return;

    }

    @EventHandler
    public void on(BorrowingUpdateBookReturnEvent event) {
        Borrowing model = borrowRepository.findByEmployeeIdAndBookIdAndReturnDateIsNull(event.getEmployee(), event.getBookId());
        model.setReturnDate(event.getReturnDate());
        borrowRepository.save(model);
    }

    @EventHandler
    public void on(BorrowSendMessageEvent event) {
        Message message = new Message(event.getEmployeeId(), event.getMessage());
        borrowService.sendMessage(message);
    }
}
