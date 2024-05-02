import java.util.Scanner;
import java.util.regex.*;

public class RhymeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the first word: ");
        String word1 = scanner.nextLine().toLowerCase();
        
        System.out.print("Enter the second word: ");
        String word2 = scanner.nextLine().toLowerCase();
        
        String sub = word1.substring(word1.length() - 2);
        Pattern pattern = Pattern.compile("[a-zA-Z]{1,2}" + sub + " ");
        Matcher matcher = pattern.matcher(word2);
        
        if (matcher.matches()) {
            System.out.println(word2 + " rhymes with " + word1);
        } else {
            System.out.println(word2 + " does not rhyme with " + word1);
        }
        
        scanner.close();
    }
}
