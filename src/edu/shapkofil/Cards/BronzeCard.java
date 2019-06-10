package edu.shapkofil.Cards;

public class BronzeCard extends Card{
    //Constructor
    public BronzeCard(String name) {
        super(name);
        initialDiscountRate = 0;
    }

    public float calculateRate(float turnover){
        float discountRate = initialDiscountRate/100;
        if(turnover >= 100 && turnover<=300){
            discountRate = 1f/100;
        }
        if(turnover>300) {
            discountRate = 2.5f/100;
        }
        return discountRate;
    }
}
