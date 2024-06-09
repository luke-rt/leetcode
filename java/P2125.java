public class P2125 {
    /**
     * https://leetcode.com/problems/number-of-laser-beams-in-a-bank
     */
    public static void main(String[] args) {
        P2125 p = new P2125();
        System.out.println(p.numberOfBeams(new String[]{
                "011001",
                "000000",
                "010100",
                "001000"
        }));
    }

    /**
     * Save count = num devices (nonzero)
     * iterate until you reach n, another instance of nonzero devices
     * multiply count * n
     * set count = n;
     */
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int count = 0;
        for(String row : bank) {
            int n = numberOfDevices(row);
//            if(count == 0) count = numberOfDevices(row);
            if(n != 0) {
                beams += count * n;
                count = n;
            }
        }

        return beams;
    }
    private int numberOfDevices(String row) {
        int c = 0;
        for(char ch : row.toCharArray()) if(ch == '1') ++c;
        return c;
    }
}
