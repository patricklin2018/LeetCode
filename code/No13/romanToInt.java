class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int tmp = 0;
        int sz = s.length();
        for (int i = 0; i < sz; ++i) {
            switch(s.charAt(i)) {
                case 'I': 
                    tmp = 1;
                    break;
                case 'V':
                    tmp = (tmp == 1 ? 3 : 5);
                    break;
                case 'X':
                    tmp = (tmp == 1 ? 8 : 10);
                    break;
                case 'L':
                    tmp = (tmp == 10 ? 30 : 50);
                    break;
                case 'C':
                    tmp = (tmp == 10 ? 80 : 100);
                    break;
                case 'D':
                    tmp = (tmp == 100 ? 300 : 500);
                    break;
                default:
                    tmp = (tmp == 100 ? 800 : 1000);
                    break;
            }
            res += tmp;
        }
        return res;
    }
}