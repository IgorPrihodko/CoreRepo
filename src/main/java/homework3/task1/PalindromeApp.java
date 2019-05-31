package homework3.task1;

public class PalindromeApp {

    public static void main(String[] args) {
        PalindromeApp palindrome = new PalindromeApp();
        System.out.println(palindrome.isPalindrome("Madam, I'm Adam!"));
    }

    private boolean isPalindrome(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        char c;

        for (int i = 0; i < text.length(); i++) {
            c = text.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString().equalsIgnoreCase(stringBuilder.reverse().toString());
    }
}
