class Solution {
    int romanToInt(string s) {
        int result = 0, tmp = 0;
        for (auto it = s.begin(); it != s.end() ; it++){
            switch (*it){
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
            result += tmp;
        }
        return result;
    }
}