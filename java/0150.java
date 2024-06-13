class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+")) {
                int snd = Integer.parseInt(stack.pop());
                int fst = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(fst + snd));
            } else if(token.equals("-")) {
                int snd = Integer.parseInt(stack.pop());
                int fst = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(fst - snd));
            } else if(token.equals("*")) {
                int snd = Integer.parseInt(stack.pop());
                int fst = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(fst * snd));
            } else if(token.equals("/")) {
                int snd = Integer.parseInt(stack.pop());
                int fst = Integer.parseInt(stack.pop());
                stack.push(Integer.toString(fst / snd));
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
