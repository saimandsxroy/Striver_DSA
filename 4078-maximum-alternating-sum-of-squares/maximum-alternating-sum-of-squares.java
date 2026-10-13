class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int MAX = 40000;

        int[] freq = new int[MAX + 1];

        for (int num : nums) {
            freq[Math.abs(num)]++;
        }

        int negativeSlots = n / 2;
        long sum = 0;

        for (int value = 0; value <= MAX; value++) {
            if (freq[value] == 0) {
                continue;
            }

            long square = (long) value * value;

            int negativeCount = Math.min(freq[value], negativeSlots);

            sum -= (long) negativeCount * square;
            negativeSlots -= negativeCount;

            int positiveCount = freq[value] - negativeCount;

            sum += (long) positiveCount * square;
        }

        return sum;
    }
}