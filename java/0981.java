class TimeMap {

    private HashMap<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map
            .computeIfAbsent(key, k -> new ArrayList<Pair<Integer, String>>())
            .add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {
        ArrayList<Pair<Integer, String>> values = map.get(key);
        if(values == null) return "";

        int left = 0;
        int right = values.size()-1;
        while(left <= right) {
            int median = (right+left)/2;
            Pair<Integer, String> val = values.get(median);

            if(val.getKey() > timestamp) {
                right = median-1;
            } else {
                if(right == left || values.get(median+1).getKey() > timestamp) {
                    return val.getValue();
                }

                left = median+1;
            }
        }
        
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
