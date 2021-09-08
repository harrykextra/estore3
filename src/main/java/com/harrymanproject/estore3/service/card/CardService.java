package com.harrymanproject.estore3.service.card;

import com.harrymanproject.estore3.data.exception.CardException;
import com.harrymanproject.estore3.data.model.Card;

import java.util.List;

public interface CardService {

    void saveCard (Card card) throws CardException;
    void updateCard (Card card) ;
    Card findCardById (Integer id);
    List<Card> findAllCards ();
    void deleteCardById (Integer id);
}
