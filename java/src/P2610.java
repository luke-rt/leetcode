import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P2610 {
    /**
     * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions
     */
    public static void main(String[] args) {
        P2610 p = new P2610();
        System.out.println(p.findMatrix(new int[]{1,3,4,1,2,3,1}));
//        System.out.println(p.findMatrix(new int[]{2,1,1}));
    }

    /**
     * for every number n in nums
     * store into frequency array: freq[n]++;
     * for each frequency, add n to every List in List<List>
     *     if frequency > the number of lists, create new lists to accomodate
     */
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        int[] freqs = new int[n + 1];

        for (int num : nums) {
            ++freqs[num];
        }

        List<List<Integer>> retval = new ArrayList<>();
        for(int i = 0; i < freqs.length; ++i) {
            if(freqs[i] != 0) {
                int size = retval.size();
                if(freqs[i] > size) {
                    for(List<Integer> ls : retval) {
                        ls.add(i);
                    }
//                System.out.println(retval + " " + (freqs[i] - retval.size()));
                    for(int j = 0; j < freqs[i] - size; ++j) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        retval.add(tmp);
                    }
                } else {
                    for(int j = 0; j < freqs[i]; ++j) {
                        retval.get(j).add(i);
                    }
                }

            }
        }

        return retval;
    }
}
