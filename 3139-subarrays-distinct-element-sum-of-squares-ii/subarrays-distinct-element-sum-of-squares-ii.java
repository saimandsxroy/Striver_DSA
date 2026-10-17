

class Solution {
    private static final long MOD = 1_000_000_007L;

    private long[] sum;
    private long[] sumSq;
    private int[] lazy;
    private int n;

    public int sumCounts(int[] nums) {
        n = nums.length;

        sum = new long[4 * n];
        sumSq = new long[4 * n];
        lazy = new int[4 * n];

        Map<Integer, Integer> lastSeen = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int prev = lastSeen.getOrDefault(nums[i], -1);

           
            update(1, 0, n - 1, prev + 1, i);

        
            ans = (ans + sumSq[1]) % MOD;

            lastSeen.put(nums[i], i);
        }

        return (int) ans;
    }

    private void apply(int node, int left, int right, int delta) {
        long len = right - left + 1L;
        long oldSum = sum[node];
        long d = delta;

    
        sumSq[node] = (
            sumSq[node]
            + (2L * d % MOD) * oldSum % MOD
            + (d * d % MOD) * len % MOD
        ) % MOD;

        sum[node] = (oldSum + d * len) % MOD;
        lazy[node] += delta;
    }

    private void pushDown(int node, int left, int right) {
        if (lazy[node] == 0 || left == right) {
            return;
        }

        int mid = left + (right - left) / 2;
        int delta = lazy[node];

        apply(node * 2, left, mid, delta);
        apply(node * 2 + 1, mid + 1, right, delta);

        lazy[node] = 0;
    }

    private void update(
        int node, int left, int right, int ql, int qr
    ) {
        if (ql <= left && right <= qr) {
            apply(node, left, right, 1);
            return;
        }

        pushDown(node, left, right);

        int mid = left + (right - left) / 2;

        if (ql <= mid) {
            update(node * 2, left, mid, ql, qr);
        }

        if (qr > mid) {
            update(node * 2 + 1, mid + 1, right, ql, qr);
        }

        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;

        sumSq[node] =
            (sumSq[node * 2] + sumSq[node * 2 + 1]) % MOD;
    }
}
