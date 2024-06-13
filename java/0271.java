class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for(String s : strs) {
            str += s.length() + "#" + s;
        }

        return str;
    }

    public List<String> decode(String str) {
        String len = "";
        List<String> decoded = new LinkedList<>();
        // decoded.add(str);
        // return decoded;
        
        int i = 0;
        while(i < str.length()) {
            char ch = str.charAt(i);
            if(ch == '#') {
                int k = Integer.parseInt(len);
                String word = "";
                for(int j = 0; j < k; ++j) {
                    ++i;
                    word += str.charAt(i);
                }
                decoded.add(word);
                len = "";
            } else {
                len += ch;
            }
            ++i;
        }
        return decoded;
    }
}

