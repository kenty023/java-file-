package com.mycompany.triprism;

import java.util.*;

class TriPrismC<T> 
{
    private T lenght;
    private T height;
    private T base;

    void setLenght(T lenght) 
    {
        this.lenght = lenght;
    }
    T getLenght()
    {
        return lenght;
    }
    void setBase(T base)
    {
        this.base = base;
    }
    T getBase()
    {
        return base;
    }
    void setHeight(T height)
    {
        this.height = height;
    }
    T getHeight()
    {
        return height;
    }
    
}

public class TriPrism 
{

    public static void main(String[] args) 
    {
       
        Scanner Console = new Scanner (System.in);
        TriPrismC <Integer> tp1 = new TriPrismC<Integer>();
        TriPrismC <Double> tp2 = new TriPrismC<Double>();
        
        double Volume;
        System.out.println("Triangular Prism 1 \n");
        
        //lenght
        System.out.print("Lenght: ");
        tp1.setLenght(Console.nextInt());
        
        //height
        System.out.print("height: ");
        tp1.setHeight(Console.nextInt());
        
        //base
        System.out.print("Base: ");
        tp1.setBase(Console.nextInt());
        
        //formula = lenght * (0.5 * base * height)
        
        Volume = tp1.getLenght() * (0.5 * tp1.getBase() * tp1.getHeight());
        System.out.println("The Volume of the Triangular Prism is : " + Volume);
        
        //tp2
        System.out.println("\n Triangular Prism 2 \n");
        
        // lenght tp2
        System.out.print("Lenght: ");
        tp2.setLenght(Console.nextDouble());
        
        //height tp2
        System.out.print("Height: ");
        tp2.setHeight(Console.nextDouble());
        
        //base
        System.out.print("Base: ");
        tp2.setBase(Console.nextDouble());
        
       Volume = tp2.getLenght() * (0.5 * tp2.getBase() * tp2.getHeight());
       System.out.println("The Volume of the Triangular Prism is : " + Volume);

    }
}
