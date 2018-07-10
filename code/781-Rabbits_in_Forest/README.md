## 781. 森林中的兔子

### 问题

森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 `answers` 数组里。

返回森林中兔子的最少数量。
```
示例:
输入: answers = [1, 1, 2]
输出: 5
解释:
两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
设回答了 "2" 的兔子为蓝色。
此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。

输入: answers = [10, 10, 10]
输出: 11

输入: answers = []
输出: 0
```

**说明:**

1. `answers` 的长度最大为`1000`。
2. `answers[i]` 是在 `[0, 999]` 范围内的整数。

### 思路

需要注意的两点：

1. 说 `0` 的，改颜色仅一只，直接加 `1`

2. 如果两只说 `1`，可能颜色相同，但是如果三只说 `1`，那么，这三只至少两种颜色。因此，我们需要一个 `Map<Integer, Integer>` 来记录说该数字的次数。

因此，步骤如下：
```
1. 如果数字为 0， 统计 +1
2. 如果 Map 中无该数字，则 Map 加入该数字，值初始为 1。并统计加上 该数字 + 1 （1 为说话的兔子）
3. 如果 Map 中有该数字， Map 中对应的值：
   a) 小于 该数字 + 1，则将该值 + 1， 统计不变
   b）大于 该数字 + 1，则将该值初始化为 1，统计加 该数字 + 1
```

### 代码
[代码链接 - JAVA](/src/Solution.java)

```java
public int numRabbits(int[] answers) {

    if (answers == null || answers.length == 0) {
        return 0;
    }

    int counter = 0;
    Map<Integer, Integer> hash = new HashMap<>();
    for (int i = 0; i < answers.length; ++i) {

        if (answers[i] == 0) {
            counter += 1;
            continue;
        }
        else if (! hash.containsKey(answers[i])) {
            hash.put(answers[i], 1);
            counter += answers[i] + 1;
        }
        else {
            if (hash.get(answers[i]) < (answers[i] + 1)) {
                hash.put(answers[i], hash.get(answers[i]) + 1);
            }
            else {
                hash.put(answers[i], 1);
                counter += answers[i] + 1;
            }
        }
    }

    return counter;
}
```