package edu.shapkofil.Cards;

public class GoldCard extends Card{
    //Constructor
    public GoldCard(String name) {
        super(name);
        initialDiscountRate = 2;
    }

    public float calculateRate(float turnover){
        float discountRate = initialDiscountRate/100f;
        if(turnover>100) {
            int addedRate = (int)turnover/100;
            discountRate = initialDiscountRate + (float)addedRate/100f;
            if(discountRate>1f/10f)discountRate = 1f/10f;
        }
        return discountRate;
    }
}
