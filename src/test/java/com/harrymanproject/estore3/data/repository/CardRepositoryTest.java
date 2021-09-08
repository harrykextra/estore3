package com.harrymanproject.estore3.data.repository;

import com.harrymanproject.estore3.data.exception.CardException;
import com.harrymanproject.estore3.data.model.Card;
import com.harrymanproject.estore3.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;

    Card card;
    @BeforeEach
    void setUp() {
        card = new Card();
    }

    @Test
    void saveCardTest() throws CardException {

        card.setCardName("Mary Kent");
        card.setCardType("visa");
        card.setCardNumber("555566667777");
        card.setExpDate("1-1-24");
        card.setCvv(234);

        Customer customer = customerRepository.findById(1).orElse(null);
        assert customer != null;
        card.setCustomer(customer);
        cardRepository.saveCard(card);

        assertThat(card.getId()).isNotNull();
    }
}