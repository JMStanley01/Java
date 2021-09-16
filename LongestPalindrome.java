import java.util.Scanner;

public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        for (int i = 0; i < line.length() - 1; i++) {
            //check to ensure all lines are non-numeral
            if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                System.out.print("Line cannot contain numbers.\nPlease enter new line: ");
                line = in.nextLine();
            }
        }
        System.out.println(longestPalindrome(line));
    }

    public static String longestPalindrome(String line) {
        String longest = " ";
        int i;
        for (i = 0; i < line.length(); i++) {
            //throws current line to helper method to check for any hidden palindromes
            String current = longestHiddenPalindrome(line.substring(i));

            if (longest.length() < current.length()) {
                longest = current;
            }
        }
        return longest;
    }

    public static String longestHiddenPalindrome(String line) {
        String longest;
        // variable to serve as the last placeholder for internal palindrome
        int end = line.length();
        while ((!palindromeCheck(line.substring(0, end))) && end > 0) {
            end--;
        }
        longest = line.substring(0, end);

        return longest;
    }

    //checks if selected line is palindrome
    public static boolean palindromeCheck(String line) {
        //create two variables that work up from both ends of the string
        int front = 0, end = line.length() - 1;
        //while the two variable have not met
        while (end > front) {
            if (!(line.charAt(front) == line.charAt(front))) {
                return false;
            }
            //move up the next rung
            ++front;
            --end;
            //end loop
        }
        return true;

    }
}
