package codeinside.app.strings;

public class Anagram {

    // normalize: ignore non-alnum + case, then compare frequency
    public static boolean isAnagram(String a, String b) {
        if (a == null || b == null) return false;

        String x = normalize(a);
        String y = normalize(b);

        if (x.length() != y.length()) return false;

        int[] cnt = new int[256];
        for (int i = 0; i < x.length(); i++) cnt[x.charAt(i)]++;
        for (int i = 0; i < y.length(); i++) cnt[y.charAt(i)]--;
        for (int v : cnt) if (v != 0) return false;

        return true;
    }

    private static String normalize(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }
        return sb.toString();
    }
}

