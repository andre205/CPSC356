package com.example.tyler.card_stack;

public class card {

    public enum suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }

    public String cardValue;
    public suit cardSuit;

    public card(String v, suit s)
    {
        this.cardValue = v;
        this.cardSuit = s;
    }

    public String getCardValue()
    {
        return cardValue;
    }

    public suit getSuit()
    {
        return cardSuit;
    }

}
