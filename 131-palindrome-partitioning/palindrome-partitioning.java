
import java.util.*;

class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();

        solve(s, 0, list, ans);

        return ans;
    }

    public void solve(String s, int index,
                      List<String> list,
                      List<List<String>> ans) {

        int n = s.length();

        if (index == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int j = index; j < n; j++) {

            if (isPalindrome(index, j, s)) {

                list.add(s.substring(index, j + 1));

                solve(s, j + 1, list, ans);

                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int index1, int index2, String s) {

        while (index1 < index2) {

            if (s.charAt(index1) != s.charAt(index2)) {
                return false;
            }

            index1++;
            index2--;
        }

        return true;
    }
}
