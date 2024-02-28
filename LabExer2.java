package com.mycompany.labexer2;

import java.util.*;

public class LabExer2 {

    private String itemName;
    private double itemPrice;
    private int itemQuantity;
    private double amountDue;

    public LabExer2(String itemName, double itemPrice, int itemQuantity) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
        this.amountDue = itemQuantity * itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public void readInput() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter the name of the item you are purchasing: ");
        itemName = s.nextLine();

        System.out.print("Enter the quantity and price separated by a space: ");
        itemQuantity = s.nextInt();
        itemPrice = s.nextDouble();

        amountDue = itemQuantity * itemPrice;
    }

   public void writeOutput() {
    System.out.printf("You are purchasing %d %s(s) at %.2f each.%n", itemQuantity, itemName, itemPrice);
    System.out.printf("Amount due is %.2f%n", amountDue);
    }

    public static void main(String[] args) {
        LabExer2 item = new LabExer2("", 0.0, 0);
        item.readInput();
        item.writeOutput();
    }
}

