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

需要注意的三点：

1. 说 `0` 的，改颜色仅一只，直接加 `1`。

2. 如果两只说 `1`，可能颜色相同，但是如果三只说 `1`，那么，这三只至少两种颜色。因此，我们需要一个哈希表来记录说该数字的次数，这里我们采用一个 `int[1000]` 数组来作为哈希表。

3. 如果记录次数超过对应 key + 1，则值归为 1，该 1 为当前该数的记录，而不是归 0。

因此，步骤如下：
```
遍历数组
1. 如果数字为 0， 统计 +1
2. 对应 hash表 的值 +1，所得到的值
    a) 如果等于 1， 则统计加 (该数字 + 1)
    b) 如果大于 (该数字 + 1)，该值归 1, 统计加 (该数字 + 1)
```

### 代码
[代码链接 - JAVA](/src/Solution.java)

```java
public int numRabbits(int[] answers) {

    if (answers == null || answers.length == 0) {
        return 0;
    }

    int counter = 0;
    int[] hash = new int[1000];
    for (int i = 0; i < answers.length; ++i) {

        if (answers[i] == 0) {
            counter += 1;
            continue;
        }

        hash[answers[i]] ++;

        if (hash[answers[i]] == 1) {
            counter += answers[i] + 1;
        }
        else if (hash[answers[i]] > answers[i] + 1) {
            hash[answers[i]] = 1;
            counter += answers[i] + 1;
        }
    }

    return counter;
}
```