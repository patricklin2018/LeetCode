# 225. 用队列实现栈

## 问题

使用队列实现栈的下列操作：

- push(x) -- 元素 x 入栈
- pop() -- 移除栈顶元素
- top() -- 获取栈顶元素
- empty() -- 返回栈是否为空

**注意:**

- 你只能使用队列的基本操作-- 也就是 `push to back`, `peek/pop from front`, `size`, 和 `is empty` 这些操作是合法的。
- 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
- 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。

## 思路

用数组实现，若需要扩容时，重新开辟数组，再将数据复制过去。

## 实现

```java
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
```

