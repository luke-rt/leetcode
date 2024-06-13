public class P1641 {
    /**
     * https://leetcode.com/problems/count-sorted-vowel-strings/
     */
    public static void main(String[] args) {
        System.out.println(SolutionC.countVowelStrings(1));
        System.out.println(SolutionC.countVowelStrings(2));
        System.out.println(SolutionC.countVowelStrings(3));
    }

    class SolutionA {
        /**
         * top down approach
         * For every vowel, treat it as a starting point for a given sequence of length n
         * index corresponds to value position, 0 = a, 1 = e, etc
         * for all the possible vowels that can immediately follow it, recall except with that vowel as starting point and n - 1
         *
         * Note: made some minor optimizations to try to reduce recalculations of identical things
         * initially had for i in range 5, total += cvssa(i, n - 1);
         * made minor optimization when i realized that was equivalent to
         * cvssa(i, n - 1) + cvssa(i + 1, n)
         */
        public static int countVowelStrings(int n) {
            // int[][] dp = new int[5][n];
            int total = 0;
            for(int i = 0; i < 5; ++i) {
                total += countVowelStringsStartingAt(i, n);
            }
            return total;
        }

        static int countVowelStringsStartingAt(int index, int n) {
            if(n == 1) return 1;
            if(n == 2) return 5 - index;

            if(index == 4) return 1;

            int total = 0;
            total += countVowelStringsStartingAt(index, n - 1) + countVowelStringsStartingAt(index + 1, n);
            return total;
        }
    }
    class SolutionB {
        /**
         * still top down
         *
         * after drawing out a tree of possible strings for n = 3, i realized
         * that given an int[n][5] array, where int[n][0] is the number of sequences of length n starting with a
         * int[n] was equal to the sum of (sum of int[n - 1] - int[n - 1][i] for i in range 5]
         * I still used recursion and i built the array from highest n, gradually calling functions on n - 1
         * and filling up the dp[][] array until the initial function call could be returned
         * dumb recursion
         */
        public static int countVowelStrings(int n) {
            int[][] dp = new int[n+1][5];

            fillDPArray(n, dp);

            return sum(dp[n]);
        }

        static void fillDPArray(int n, int[][] dp) {
            if(n == 1) {
                dp[n] = new int[]{1, 1, 1, 1, 1};
            } else if(dp[n] != null) {
                fillDPArray(n - 1, dp);

                int tmp = sum(dp[n - 1]);
                dp[n][0] = tmp;
                for(int i = 0; i < 4; ++i) {
                    tmp -= dp[n - 1][i];
                    dp[n][i + 1] = tmp;
                }
            }
        }

        static int sum(int[] arr) {
            int total = 0;
            for(int i = 0; i < 5; ++i) total += arr[i];

            return total;
        }
    }

    class SolutionC {
        /**
         * bottom up approach finally
         *
         * Realized that instead of calling dp[n], and using dp[n-1] to resolve it
         * I could start with dp[n-1] and work my way up to dp[n]
         *
         * that meant that I also didnt need a 2d array of length n, since i would only
         * ever have to access dp[n - 1]. no point saving dp[n - 2]. I can just maintain
         * dp array of length 5 and overwrite it with n++
         *
         * started with dp = [1,1,1,1,1]
         * built dp2 with accumulating sum, to be
         * [1, 2, 3, 4, 5]
         * [1,3,6,10,15]
         * [1,4,10,20,35]
         *
         * the answer countVowelStrings(n) is the sum of the array at iteration n-1
         */
        public static int countVowelStrings(int n) {
            int[] dp = new int[]{1, 1, 1, 1, 1};

            for(int i = 1; i < n; ++i) {
                for(int j = 0; j < 4; ++j) {
                    dp[j + 1] += dp[j];
                }
            }

            int total = 0;
            for(int i = 0; i < 5; ++i) total += dp[i];
            return total;
        }
    }
}
