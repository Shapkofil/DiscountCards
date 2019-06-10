package edu.shapkofil.Core;

import edu.shapkofil.Cards.*;
public class PayDesk {

    public static float calculateDiscountRate(float turnover,Card card) {
        return card.calculateRate(turnover) * 100;
    }

    public static float calculateDiscount(float turnover,float purchaseValue,Card card){
        float discountRate = card.calculateRate(turnover);
        return purchaseValue * discountRate;
    }

    public static float calculateTotal(float turnover,float purchaseValue,Card card){
        float discountRate = card.calculateRate(turnover);
        return purchaseValue * (1-discountRate);
    }
}
