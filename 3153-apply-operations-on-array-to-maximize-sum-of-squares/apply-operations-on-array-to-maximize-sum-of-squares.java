
import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;

        // Count how many numbers contain each bit
        int[] bitCount = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if (((num >> bit) & 1) == 1) {
                    bitCount[bit]++;
                }
            }
        }

        long ans = 0;

        // Greedily construct k maximum numbers
        for (int i = 0; i < k; i++) {
            long x = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    x |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            // Use long to prevent overflow
            ans = (ans + (x * x) % MOD) % MOD;
        }

        return (int) ans;
    }
}
