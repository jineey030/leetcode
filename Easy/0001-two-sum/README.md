# 0001. Two Sum (Easy)

## 문제 요약
정수 배열 `nums`에서 합이 `target`이 되는 두 수의 인덱스를 반환한다.

## 풀이 1: 이중 for문 (Brute Force)
- 모든 두 수의 조합을 확인한다.
- 시간 복잡도 O(n²), 공간 복잡도 O(1)
- 결과: Accepted, 50ms (Beats 6.01%)

## 풀이 2: HashMap
- 배열을 한 번 돌면서, 각 숫자에 대해 **짝이 되는 수(`target - nums[i]`)가 이미 나왔는지** 확인한다.
- 나온 숫자는 `HashMap<숫자, 인덱스>`에 저장해 둔다.
- 시간 복잡도 O(n), 공간 복잡도 O(n)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // key: 숫자, value: 인덱스

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
```

## 배운 점
- **HashMap은 "찾기"를 O(1)로 만들어 준다.**
  이중 for문에서 안쪽 반복문이 하던 일은 "짝이 되는 수가 어디 있는지 찾기"였다.
  이 탐색을 HashMap에 맡기면 반복문 하나로 해결된다.
- **무엇을 key로, 무엇을 value로 둘지가 핵심이다.**
  찾고 싶은 대상(숫자)을 key로, 알고 싶은 정보(인덱스)를 value로 저장했기 때문에
  `map.get(숫자)`로 바로 인덱스를 얻을 수 있다.
- **"두 수의 합" 문제는 "하나를 정하면 나머지는 정해진다"로 바꿔 생각할 수 있다.**
  `a + b = target`이면 `b = target - a`이므로, 쌍을 찾는 문제가 값 하나를 찾는 문제로 바뀐다.
- **저장보다 확인을 먼저 해야 한다.**
  `put`보다 `containsKey`를 먼저 해야 같은 원소를 두 번 쓰지 않는다.
  예를 들어 `nums = [3, 3]`, `target = 6`일 때도 올바르게 `[0, 1]`이 나온다.
- 시간을 줄이려고 메모리를 더 쓰는 트레이드오프다. (O(1) → O(n) 공간)

## 링크
https://leetcode.com/problems/two-sum/
