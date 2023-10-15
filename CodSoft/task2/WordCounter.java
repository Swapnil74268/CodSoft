import java.util.Scanner;

public class WordCounter {
    public static void main(String args[]) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter a sentence:");
            String str = in.nextLine();
            System.out.println("Enter a word:");
            String Word = in.nextLine();
            str += " ";
            String word = "";
            int count = 0;
            int len = str.length();
    
            for (int i = 0; i < len; i++) {

                if (str.charAt(i) == ' ') {
    
                    if (word.equalsIgnoreCase(Word))
                        count++ ;
    
                    word = "";
                }
                else {
                    word += str.charAt(i);
                }
            }
            
            if (count > 0) {
                System.out.println(Word + " is present " + count + " times.");
            }
            else {
                System.out.println(Word + " is not present in sentence.");
            }
            
        }

}
