
class Solution {

    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] prevDiff = new int[n];

        int lastChar = -1;
        int lastPos = -1;
        int secondPos = -1;

        for (int i = 0; i < n; i++) {

            int c = word1.charAt(i) - 'a';

            if (c == lastChar) {
                prevDiff[i] = secondPos;
                lastPos = i;
            } else {
                prevDiff[i] = lastPos;
                secondPos = lastPos;
                lastChar = c;
                lastPos = i;
            }
        }

        int[] bestExact = new int[m + 1];
        int[] bestOne = new int[m + 1];

        bestExact[m] = n;
        bestOne[m] = n;

        int p0 = n - 1;
        int p1 = n - 1;

        for (int j = m - 1; j >= 0; j--) {

            char target = word2.charAt(j);

            p0 = Math.min(p0, bestExact[j + 1] - 1);

            while (p0 >= 0 && word1.charAt(p0) != target) {
                p0--;
            }

            bestExact[j] = Math.max(-1, p0);
            p0 = bestExact[j] - 1;

            p1 = Math.min(p1, bestOne[j + 1] - 1);

            while (p1 >= 0 && word1.charAt(p1) != target) {
                p1--;
            }

            int equal = Math.max(-1, p1);

            int mismatch = -1;
            int bound = bestExact[j + 1];

            if (bound > 0) {

                int idx = bound - 1;

                if (word1.charAt(idx) != target) {
                    mismatch = idx;
                } else {
                    mismatch = prevDiff[idx];
                }
            }

            bestOne[j] = Math.max(equal, mismatch);

            p1 = bestOne[j] - 1;
        }

        int[] ans = new int[m];

        int ptr = 0;
        boolean usedMismatch = false;

        for (int j = 0; j < m; j++) {

            boolean found = false;

            while (ptr < n) {

                boolean equal =
                    word1.charAt(ptr) == word2.charAt(j);

                boolean possible;

                if (equal) {

                    int boundary = usedMismatch
                        ? bestExact[j + 1]
                        : bestOne[j + 1];

                    possible = boundary > ptr;

                } else {

                    possible = !usedMismatch &&
                               bestExact[j + 1] > ptr;
                }

                if (possible) {

                    ans[j] = ptr;

                    if (!equal) {
                        usedMismatch = true;
                    }

                    ptr++;
                    found = true;
                    break;
                }

                ptr++;
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }
}
