package No225;
/**
 * @Author: patrick-mac
 * @Date: 2018/9/8 15:14
 * @Description:
 */
public class Solution {
    class MyStack {

        int[] data;
        int capacity;
        int size;


        /** Initialize your data structure here. */
        public MyStack() {
            this.capacity = 16;
            this.data = new int[16];
            this.size = 0;
        }

        /** Push element x onto stack. */
        public void push(int x) {
            if (size >= capacity - 1) {
                // 扩容
                int[] newData = new int[capacity * 2];
                for (int i = 0; i < size; ++i) {
                    newData[i] = data[i];
                }
                data = newData;
            }

            data[size++] = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            // if (size <= 0) {
            //     throw new Exception("it's null");
            // }
            return data[--size];
        }

        /** Get the top element. */
        public int top() {
            return data[size - 1];
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return size == 0;
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
