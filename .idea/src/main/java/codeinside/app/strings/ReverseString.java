package codeinside.app.strings;

public class ReverseString {

    public static String reverse(String s) {
        if (s == null) return null;
        return new StringBuilder(s).reverse().toString();
    }
}
