package com.example.model;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Deck {

    public Deck() {
        this.deck = initDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    private ArrayList<Card> deck;

    private ArrayList<Card> initDeck(){
        final ArrayList<Card> deck = new ArrayList<Card>();
        for(Card.Suit suit : Card.Suit.values()){
            for(Card.Rank rank : Card.Rank.values()){
                deck.add(Card.getCard(rank, suit));
            }
        }
        return deck;
    }

    public void shuffle(ArrayList<Card>  deck){
        final int deckSize = deck.size();
        Random rand = new Random();
        for(int i=0; i<deckSize; i++){
            int index = rand.nextInt(deckSize-i);
            //copy last card in deck with random picked card
            Card randomCardIndex = deck.get(index);
            Card lastCard = deck.get(deckSize-1-i);
            deck.set(index, lastCard);
            deck.set(deckSize-1-i, randomCardIndex);
        }
    }

    public Optional<Card> dealOneCard(){
        //remove card from end of deck
        return this.deck.isEmpty() ? Optional.empty() : Optional.of(this.deck.remove(deck.size()-1));
    }

    @Override
    public String toString() {
        String deckOutput = "";
         deck.forEach(card->{
             String.format("%s%s", deckOutput, card.toString());
         });
         return deckOutput;
    }
}
