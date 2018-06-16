class Solution {
    int myAtoi(string str) {
        int int_max = 2147483647, int_min = -2147483648, size = str.size(), indicator = 1;
        long long res = 0;
        int i = str.find_first_not_of(' ');
        if (str[i] == '+' || str[i] == '-'){
            indicator = 1 - 2 * (str[i++] == '-');
        }
        while (i < size && str[i] >= '0' && str[i] <= '9'){
            res = res * 10 + (str[i++] - '0');
            if (indicator * res >= int_max) return int_max;
            if (indicator * res <= int_min) return int_min;
        }
        return indicator * res;
    }
}