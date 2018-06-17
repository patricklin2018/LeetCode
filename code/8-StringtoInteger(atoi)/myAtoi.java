/**
 * @author Patrick-lenovo
 * @create 2018/6/17 1:19
 **/
public class myAtoi {
    public int myAtoi(String str) {
        if (str.length() == 0)
            return 0;
        int size = str.length();

        int i = 0;
        // 查找非空字符
        for (; i < size; ++i) {
            if (str.charAt(i) != ' ') {
                break;
            }
        }

        // 检查 '+' '-'
        int indicator = 1;
        if (i < size && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            indicator = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        int res = 0;
        while (i < size && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int val = (str.charAt(i++) - '0');
            // 检查越界
            if (Integer.MAX_VALUE / 10 < res || (Integer.MAX_VALUE / 10 == res && Integer.MAX_VALUE % 10 < val)) {
                return indicator == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            // 计算和
            res = res * 10 + val;
        }

        return res * indicator;
    }

    /*
        测试
     */
    public static void main(String[] args) {
        System.out.println(new myAtoi().myAtoi(" "));
    }
}
