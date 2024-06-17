class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> indices = new Stack<>();

        indices.push(0);
        int index = 1;
        while(index < temperatures.length) {
            if(indices.empty() || temperatures[index] <= temperatures[indices.peek()]) {
                indices.push(index);
                ++index;
            } else {
                int i = indices.pop();
                answer[i] = index - i;
            }
        }

        return answer;
    }
}
