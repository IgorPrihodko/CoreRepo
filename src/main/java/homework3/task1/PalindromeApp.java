package homework3.task1;

public class PalindromeApp {

    public static void main(String[] args) {
        PalindromeApp palindrome = new PalindromeApp();
        System.out.println(palindrome.isPalindrome("Madam, I'm Adam!"));
    }

    private boolean isPalindrome(String text) {
        StringBuilder newString = new StringBuilder(text.replaceAll("[^a-zA-Z0-9]", ""));
        return newString.toString().equalsIgnoreCase(newString.reverse().toString());
    }
}
