package codeinside.app.strings;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s == null) return false;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);

            if (!Character.isLetterOrDigit(a)) { i++; continue; }
            if (!Character.isLetterOrDigit(b)) { j--; continue; }

            a = Character.toLowerCase(a);
            b = Character.toLowerCase(b);

            if (a != b) return false;
            i++; j--;
        }
        return true;
    }
}
