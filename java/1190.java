class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(new StringBuilder());
            } else if (ch == ')') {
                StringBuilder top = stack.pop();

                if(stack.isEmpty()) {
                    stack.push(top.reverse());
                } else {
                    stack.peek().append(top.reverse());
                }
            } else {
                if(stack.isEmpty()) {
                    stack.push(new StringBuilder().append(ch));
                } else {
                    stack.peek().append(ch);
                }
            }
        }

        return stack.pop().toString();
    }
}
