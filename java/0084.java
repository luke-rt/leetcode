class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer, Integer>> indices = new Stack<>();
        int max = 0;

        int i = 0;
        int index = 0;
        while(i < heights.length) {
            if(indices.isEmpty() || heights[i] >= indices.peek().getValue()) {
                indices.push(new Pair<>(index, heights[i]));
                ++i;
                index = i;
            } else {
                Pair<Integer, Integer> top = indices.pop();
                max = Math.max(max, top.getValue() * (i - top.getKey()));
                index = top.getKey();
            }
        }

        while(!indices.isEmpty()) {
            Pair<Integer, Integer> top = indices.pop();
            max = Math.max(max, top.getValue() * (i - top.getKey()));  
        }

        return max;
    }
}

