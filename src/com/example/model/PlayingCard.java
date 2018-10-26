package com.example.model;

public class PlayingCard {
    public static void main(String[] args) {
        Deck playingDeck = new Deck();
        playingDeck.shuffle(playingDeck.getDeck());
        playingDeck.getDeck().forEach(card -> System.out.println(card.toString()));
        System.out.println("******************");
        for(int i=0; i<=52;i++){
            System.out.println("Card out -- " + playingDeck.dealOneCard().toString());
        }
    }
}
