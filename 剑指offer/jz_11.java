package 剑指offer;

/**
 * 旋转数组的最小数字    即寻找旋转点
 * 给你一个可能存在重复元素值的数组numbers，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。
 * 思路：二分法   note：二分法边界问题，预演出现决策边界情况，再考虑处理方法
 */
public class jz_11 {
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
}
