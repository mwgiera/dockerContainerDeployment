package codeinside.app;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import codeinside.app.katas.TwoSum;
import codeinside.app.katas.WordCount;
import codeinside.app.strings.Palindrome;
import codeinside.app.collections.Duplicates;

public class Runner {

    public static void main(String[] args) {
        System.out.println("=== Java Interview Mini Harness (Java 8 style) ===\n");

        testPalindrome();
        testTwoSum();
        testWordCount();
        testDuplicates();

        System.out.println("\nDONE ✅");
    }

    private static void testPalindrome() {
        System.out.println("[Palindrome]");
        assertEq(true, Palindrome.isPalindrome("A man, a plan, a canal: Panama"), "classic phrase");
        assertEq(false, Palindrome.isPalindrome("race a car"), "not palindrome");
        assertEq(true, Palindrome.isPalindrome(""), "empty string");
        System.out.println();
    }

    private static void testTwoSum() {
        System.out.println("[TwoSum]");
        int[] a = new int[]{2, 7, 11, 15};
        int[] r = TwoSum.twoSum(a, 9);
        assertEq(true, Arrays.equals(new int[]{0, 1}, r), "2+7=9");

        int[] b = new int[]{3, 2, 4};
        int[] r2 = TwoSum.twoSum(b, 6);
        assertEq(true, Arrays.equals(new int[]{1, 2}, r2), "2+4=6");

        int[] c = new int[]{1, 2, 3};
        int[] r3 = TwoSum.twoSum(c, 99);
        assertEq(true, Arrays.equals(new int[]{-1, -1}, r3), "no solution");
        System.out.println();
    }

    private static void testWordCount() {
        System.out.println("[WordCount]");
        Map<String, Integer> m = WordCount.count("a a b  b   c");
        assertEq(2, m.get("a"), "count a");
        assertEq(2, m.get("b"), "count b");
        assertEq(1, m.get("c"), "count c");

        Map<String, Integer> empty = WordCount.count("   ");
        assertEq(0, empty.size(), "blank input => empty map");
        System.out.println();
    }

    private static void testDuplicates() {
        System.out.println("[Duplicates]");
        Set<Integer> d = Duplicates.findDuplicates(new int[]{1, 2, 2, 3, 3, 3, 4});
        assertEq(true, d.contains(2), "contains 2");
        assertEq(true, d.contains(3), "contains 3");
        assertEq(false, d.contains(1), "does not contain 1");
        System.out.println();
    }

    // --- tiny assertion helpers (interview-friendly) ---
    private static void assertEq(Object expected, Object actual, String name) {
        boolean ok = (expected == null) ? (actual == null) : expected.equals(actual);
        System.out.println((ok ? "  ✅ " : "  ❌ ") + name + " | expected=" + expected + " actual=" + actual);
        if (!ok) throw new AssertionError("FAILED: " + name);
    }

    private static void assertEq(boolean expected, boolean actual, String name) {
        System.out.println(((expected == actual) ? "  ✅ " : "  ❌ ") + name + " | expected=" + expected + " actual=" + actual);
        if (expected != actual) throw new AssertionError("FAILED: " + name);
    }
}
