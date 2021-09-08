package com.harrymanproject.estore3.service.card;

import com.harrymanproject.estore3.data.exception.CardException;
import com.harrymanproject.estore3.data.model.Card;
import com.harrymanproject.estore3.data.repository.CardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CardServiceImplTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService = new CardServiceImpl();
    Card card;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        card = new Card();
    }

    @Test
    void saveCardTest() throws CardException{
        cardService.saveCard(card);
        verify(cardRepository, times(1)).saveCard(card);
    }

    @Test
    void updateCardTest(){
        cardService.updateCard(card);
        verify(cardRepository, times(1)).save(card);
    }

    @Test
    void findCardByIdTest(){
        when(cardRepository.findById(1)).thenReturn(Optional.of(card));
        cardService.findCardById(1);
        verify(cardRepository, times(1)).findById(1);
    }

    @Test
    void findAllCardsTest(){
        when(cardRepository.findAll()).thenReturn(List.of(card));
        cardService.findAllCards();
        verify(cardRepository, times(1)).findAll();
    }

    @Test
    void deleteCardByIdTest(){
        cardService.deleteCardById(2);
        verify(cardRepository, times(1)).deleteById(2);
    }
}