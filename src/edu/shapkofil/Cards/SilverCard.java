package edu.shapkofil.Cards;

public class SilverCard extends Card{
    //Constructor
    public SilverCard(String name) {
        super(name);
        initialDiscountRate = 2;
    }

    public float calculateRate(float turnover){
        float discountRate = initialDiscountRate/100;
        if(turnover>300) {
            discountRate = 3.5f/100;
        }
        return discountRate;
    }
}
