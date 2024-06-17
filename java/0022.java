class Solution {
    static List<String> ans;
    static int N;
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<>();
        N = n;

        backtrack(1, 0, new StringBuilder("("));

        return ans;
    }

    void backtrack(int opened, int closed, StringBuilder s) {
        if(opened == N) {
            if(opened == closed) {
                ans.add(s.toString());
                return;
            }
        } else {
            s.append('(');
            backtrack(opened+1, closed, s);
            s.deleteCharAt(s.length()-1);
        }
        
        if(opened > closed) {
            s.append(')');
            backtrack(opened, closed+1, s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
