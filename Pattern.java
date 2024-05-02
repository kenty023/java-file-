import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RhymeDetector {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the first word: ");
    String word1 = scanner.nextLine().toLowerCase();

    System.out.print("Enter the second word: ");
    String word2 = scanner.nextLine().toLowerCase();

    if (rhyme(word1, word2)) {
      System.out.println(word2 + " rhymes with " + word1);
    } else {
      System.out.println(word2 + " does not rhyme with " + word1);
    }
  }

  public static boolean rhyme(String word1, String word2) {
    String sub = word1.substring(word1.length() - 2);
    String pattern = "[a-zA-Z]{1,2}" + sub + " ";
    Matcher matcher = Pattern.compile(pattern).matcher(word2);
    return matcher.matches();
  }
}
