class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') chars.push(')');
            else if(ch == '{') chars.push('}');
            else if(ch == '[') chars.push(']');
            else if(chars.isEmpty() || chars.pop() != ch) return false;
        }
        return chars.isEmpty();
    }
}
