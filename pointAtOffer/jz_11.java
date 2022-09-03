package pointAtOffer;

/**
 * 旋转数组的最小数字    即寻找旋转点
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 思路：二分法   note：二分法边界问题，预演出现决策边界情况，再考虑处理方法
 */
public class jz_11 {
    // 关注右边界！👍
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] < numbers[right]) {            // 断点在左边
                right = mid;        // mid处可能是最小值
            } else if (numbers[mid] > numbers[right]) {     // 断点在右边
                left = mid + 1;     // mid处不会是最小值
            } else {                // 处理重复数字，跳过即可
                right--;
            }
        }
        return numbers[left];
    }

    //《剑指 offer》官方解法
    public int minArray2(int[] numbers) {
        int l = 0, r = numbers.length - 1, m = 0;
        while (numbers[l] >= numbers[r]) {
            // 循环结束，找到最小元素
            if (r == l + 1) {
                m = r;
                break;
            }
            m = (l + r) / 2;
            // 如果下标为l、m、r所指向的三个数字相等，则只能使用顺序查找
            if (numbers[l] == numbers[m] && numbers[m] == numbers[r])
                return MinInOrder(numbers, l, r);
            if (numbers[m] >= numbers[l])   // mid 处在前面的有序递增子数组
                l = m;
            else if (numbers[m] <= numbers[r]) // mid 处在后面的有序递增子数组
                r = m;
        }
        return numbers[m];
    }

    private int MinInOrder(int[] numbers, int l, int r) {
        int min = numbers[l];
        for (int i : numbers) {
            min = Math.min(min, i);
        }
        return min;
    }
}
