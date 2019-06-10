package edu.shapkofil.Cards;

public abstract class Card {

    private String ownerName;

    protected float initialDiscountRate;

    public Card(String Name) {
        ownerName = Name;
    }

    public abstract float calculateRate(float turnover);

}
