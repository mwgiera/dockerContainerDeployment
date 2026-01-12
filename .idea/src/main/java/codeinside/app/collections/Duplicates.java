package codeinside.app.collections;

import java.util.HashSet;
import java.util.Set;

public class Duplicates {

    public static Set<Integer> findDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        if (nums == null) return dup;

        for (int n : nums) {
            if (!seen.add(n)) dup.add(n);
        }
        return dup;
    }
}
