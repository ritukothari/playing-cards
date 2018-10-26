package com.example.model;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {
    private Rank rank;
    private Suit suit;

    public final static Map<String, Card> CARD_CACHE = initializeDeck();

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    private static Map<String, Card> initializeDeck(){
        final Map<String, Card> cache = new HashMap<String, Card>();
        for(Suit suit : Suit.values()){
            for(Rank rank : Rank.values()){
                cache.put(getCardKey(rank,suit),new Card(rank, suit));
            }
        }
        return Collections.unmodifiableMap(cache);
    }

    private static String getCardKey(Rank rank, Suit suit){
        return rank+"_"+suit+"key";
    }

    public static Card getCard(Rank rank, Suit suit){
        return CARD_CACHE.get(getCardKey(rank,suit));
    }

    enum Suit{
        SPADES, HEART, CLUB, DIAMONDS;
    }

    enum Rank{
        ACE, TWO, THREE,FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }

    @Override
    public String toString() {
        return String.format("%s of %s",this.rank, this.suit);
    }
}
