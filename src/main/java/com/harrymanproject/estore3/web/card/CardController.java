package com.harrymanproject.estore3.web.card;

import com.harrymanproject.estore3.data.exception.CardException;
import com.harrymanproject.estore3.data.model.Card;
import com.harrymanproject.estore3.service.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/create")
    public ResponseEntity<?> saveCard(@RequestBody Card card) throws CardException {
        cardService.saveCard(card);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCard(@RequestBody Card card) {
        cardService.updateCard(card);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCardById(@PathVariable Integer id){
        Card card = cardService.findCardById(id);
        return new ResponseEntity<>(card, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCards(){
        List<Card> cards = cardService.findAllCards();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCardById(@PathVariable Integer id){
        cardService.deleteCardById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
