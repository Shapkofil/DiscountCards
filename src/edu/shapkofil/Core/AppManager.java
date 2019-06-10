package edu.shapkofil.Core;

import edu.shapkofil.UI.UIManager;
import edu.shapkofil.Cards.*;

public class AppManager {

    public UIManager uiManager;
    private Card card;

    //Object fields holding inputs
    private float turnover = -1;
    private float purchaseValue = -1;

    private String customerName;

    public AppManager(){
        run();
    }

    public void run(){
        uiManager = new UIManager(this);
        uiManager.mainMenu();
    }

    public void ChangeCard(String control){
        switch (control){
            case "g":
                card = new GoldCard(customerName);
                break;
            case "s":
                card = new SilverCard(customerName);
                break;
            case "b":
                card = new BronzeCard(customerName);
        }
        uiManager.mainMenu();
    }

    public void setParms(float turnoverPrime,float purchaseValuePrime) {
        if(turnoverPrime >= 0 && purchaseValuePrime >= 0) {
            turnover = turnoverPrime;
            purchaseValue = purchaseValuePrime;
        }
    }

    public void setCustomerName(String name)
    {
        customerName = name;
    }

    public float getTurnover(){
        return turnover;
    }

    public float getPurchaseValue(){
        return purchaseValue;
    }

    public Card getCard() {
        return card;
    }

}
