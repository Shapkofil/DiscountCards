package edu.shapkofil.UI;

import edu.shapkofil.Core.AppManager;
import edu.shapkofil.Core.PayDesk;

import java.util.Scanner;

public class UIManager {

    private AppManager appManager;
    private Scanner scanner = new Scanner(System.in);

    public  UIManager(AppManager am){
        appManager = am;

        //setting the name of the user
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Enter your name :");
        appManager.setCustomerName(scanner.nextLine());
    }

    public void  mainMenu() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("MainMenu");
        System.out.println("1.Change card");
        System.out.println("2.Enter purchase data");
        System.out.println("3.Get purchase details");
        System.out.println("4.Exit");
        System.out.print("Choose an option:");



        int menuControll = scanner.nextInt();

        switch(menuControll) {
            case 1:
                //Clearing the screen
                System.out.print("\033[H\033[2J");
                System.out.flush();
                changeCardMenu();
                //The return statement is preventing deep recursion
                return;
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                inputMenu();
                return;
            case 3:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                output();
                return;
            case 4:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.exit(0);
                break;
            default:
                mainMenu();
                //No need for return statement since it's the method's end anyways
        }

    }
    private void changeCardMenu() {
        System.out.println("Choose a card type. Gold,Silver or Bronze (g/s/b):");
        String control = scanner.next();

        switch(control){
            case "G":
                control = "g";
                break;
            case "S":
                control = "s";
                break;
            case "B":
                control = "b";
                break;
            case "b":

            case "s":

            case "g":
                break;
            default:
                changeCardMenu();
                return;
        }

        appManager.ChangeCard(control);
    }

    private void inputMenu(){
        System.out.print("Enter turnover for the previous mouth:");
        float turnover = scanner.nextFloat();

        System.out.print("Enter purchase cost:");
        float purchaseValue = scanner.nextFloat();

        //passing inputs to appManager
        appManager.setParms(turnover,purchaseValue);

        //returning to main menu
        mainMenu();
    }

    private void output() {
        //checking for a card
        if(appManager.getCard() == null){
            System.out.println("Choose a card first.");
            pressAnyKeyToContinue();
            //returning to main menu
            mainMenu();
        }
        //checking for purchase info
        if(appManager.getPurchaseValue()<0) {
            System.out.println("Enter purchase information first.");
            pressAnyKeyToContinue();
            //returning to main menu
            mainMenu();
        }


        System.out.println("Initial purchase cost: " + appManager.getPurchaseValue());
        System.out.println("Discount rate is : " +
                PayDesk.calculateDiscountRate(appManager.getTurnover(),appManager.getCard()) + "%");
        System.out.println("Discount is : " +
                PayDesk.calculateDiscount(appManager.getTurnover(),appManager.getPurchaseValue(),appManager.getCard()));
        System.out.println("Total cost is : " +
                PayDesk.calculateTotal(appManager.getTurnover(),appManager.getPurchaseValue(),appManager.getCard()));

        pressAnyKeyToContinue();

        //returning to main menu
        mainMenu();
    }

    private void pressAnyKeyToContinue(){
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
