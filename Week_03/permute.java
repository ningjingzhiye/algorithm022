import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] visited = new int[nums.length];
        backtrack(nums, visited, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] nums, int[] visited, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            tmp.add(nums[i]);
            backtrack(nums, visited, tmp, res);
            visited[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }

}
