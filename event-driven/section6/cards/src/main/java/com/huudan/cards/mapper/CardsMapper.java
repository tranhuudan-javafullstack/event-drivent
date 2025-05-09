package com.huudan.cards.mapper;

import com.huudan.cards.command.event.CardUpdatedEvent;
import com.huudan.cards.dto.CardsDto;
import com.huudan.cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setActiveSw(cards.isActiveSw());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardType(cardsDto.getCardType());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        return cards;
    }

    public static Cards mapEventToCard(CardUpdatedEvent event, Cards card) {
        card.setCardType(event.getCardType());
        card.setTotalLimit(event.getTotalLimit());
        card.setAmountUsed(event.getAmountUsed());
        card.setAvailableAmount(event.getAvailableAmount());
        return card;
    }

}
