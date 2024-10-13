package com.mycompany.booktitles;
import java.util.*;

public class BookTitles
{

    public static void main(String[] args) 
    {
      Scanner get = new Scanner (System.in);
      Stack <String> stack = new Stack <>();
      Queue <String> queue = new LinkedList <>();
      
        System.out.println("ENTER BOOK TITLES");
      for(int i = 0; i < 4; i++)
      {
        System.out.print((i + 1) + " Boook: ");
        stack.push(get.nextLine());
      }
      
      for (int i = 0; i < 4; i++)
      {
          queue.add(stack.pop());
      }
      
        System.out.print("New order of books: [");
        String delimiter = "";  
        for (String book : queue)
        {
            System.out.print(delimiter + book);
            delimiter = ", "; 
        }
            System.out.println("]");
    }
}
