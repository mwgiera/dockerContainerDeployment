package codeinside.app.katas;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    // returns indices or {-1, -1} when not found
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[]{-1, -1};

        Map<Integer, Integer> indexByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (indexByValue.containsKey(need)) {
                return new int[]{indexByValue.get(need), i};
            }
            indexByValue.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
