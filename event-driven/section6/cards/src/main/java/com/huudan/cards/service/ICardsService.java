package com.huudan.cards.service;

import com.huudan.cards.command.event.CardUpdatedEvent;
import com.huudan.cards.dto.CardsDto;
import com.huudan.cards.entity.Cards;

public interface ICardsService {

    /**
     *
     * @param card - Cards Object
     */
    void createCard(Cards card);
    /**
     *
     * @param mobileNumber - Input mobile Number
     *  @return Card Details based on a given mobileNumber
     */
    CardsDto fetchCard(String mobileNumber);

    /**
     *
     * @param event - CardUpdatedEvent Object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardUpdatedEvent event);

    /**
     *
     * @param cardNumber - Input Card Number
     * @return boolean indicating if the delete of card details is successful or not
     */
    boolean deleteCard(Long cardNumber);

    /**
     * @param oldMobileNumber - Old mobile number of Card
     *  @param newMobileNumber - New mobile number of Card
     * @return boolean indicating if the update of mobile number is successful or not
     */
    boolean updateMobileNumber(String oldMobileNumber, String newMobileNumber);

}
