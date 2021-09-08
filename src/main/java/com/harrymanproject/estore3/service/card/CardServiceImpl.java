package com.harrymanproject.estore3.service.card;

import com.harrymanproject.estore3.data.exception.CardException;
import com.harrymanproject.estore3.data.model.Card;
import com.harrymanproject.estore3.data.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    CardRepository cardRepository;

    @Override
    public void saveCard(Card card) throws CardException {
        cardRepository.saveCard(card);
    }

    @Override
    public void updateCard(Card card) {
        cardRepository.save(card);
    }

    @Override
    public Card findCardById(Integer id) {
        return cardRepository.findById(id).orElse(null);
    }

    @Override
    public List<Card> findAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public void deleteCardById(Integer id) {
        cardRepository.deleteById(id);
    }
}
