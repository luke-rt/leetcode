import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr = s.toCharArray();
        char[] other = t.toCharArray();

        Arrays.sort(arr);
        Arrays.sort(other);

        return Arrays.equals(arr, other);
    }
}
