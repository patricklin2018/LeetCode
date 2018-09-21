import java.util.Stack;

/**
 * @Author: patrick-mac
 * @Date: 2018/9/21 10:23
 * @Description:
 */
public class Solution {

    public static String simplifyPath(String path) {
        String[] pathes = path.split("/");

        Stack<String> stack = new Stack<>();
        for (int i = 0; i < pathes.length; ++i) {
            if (!pathes[i].equals("/") && !pathes[i].equals(".") && !pathes[i].equals("") && !pathes[i].equals("..")) {
                stack.push(pathes[i]);
            }
            else if (pathes[i].equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        String str = "/home/";
        System.out.println(simplifyPath(str));
    }
}
