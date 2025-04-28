package com.huudan.cards.query.handler;

import com.huudan.cards.dto.CardsDto;
import com.huudan.cards.query.FindCardQuery;
import com.huudan.cards.service.ICardsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Component
public class CardQueryHandler {

    ICardsService iCardsService;

    @QueryHandler
    public CardsDto findCard(FindCardQuery query) {
        return iCardsService.fetchCard(query.getMobileNumber());
    }

}
