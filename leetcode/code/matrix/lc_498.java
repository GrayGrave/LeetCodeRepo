package leetcode.code.matrix;

import java.util.Arrays;

/**
 * 对角线遍历   即蛇形打印
 * 思路: 确定起止点，进行斜线打印
 */
public class lc_498 {
    int index = 0;   // note：static int index = 0; 力扣测试时，一个测试用例创建一个对象实例，static静态变量会导致index越界

    public int[] findDiagonalOrder(int[][] matrix) {
        int Ax = 0, Ay = 0;         // A箭头负责矩阵左下部分的移动
        int Bx = 0, By = 0;         // B箭头负责矩阵右上部分的移动，箭头A、B会在矩阵右下角碰头，因为走的步数一样多
        int Endx = matrix[0].length - 1;
        int Endy = matrix.length - 1;

        int res[] = new int[matrix.length * matrix[0].length];
        boolean fromUp = false;    // 是否是从右上往左下打印
        while (By <= Endy + 1) {
            printLevel(matrix, Ax, Ay, Bx, By, fromUp, res);
            // A箭头先下后右    此处有坑：注意两排顺序，交换顺序打印会出错
            Ax = Ay == Endy ? Ax + 1 : Ax;
            Ay = Ay == Endy ? Ay : Ay + 1;

            // B箭头先右后下
            By = Bx == Endx ? By + 1 : By;
            Bx = Bx == Endx ? Bx : Bx + 1;

            fromUp = !fromUp;          // 调整打印方向
        }
        return res;
    }

    // 打印两点连线的数字
    private void printLevel(int[][] matrix, int ax, int ay, int bx, int by, boolean fromUp, int[] res) {
        if (fromUp) {  // 从B箭头到A箭头打印
            while (by <= ay) {
                res[index++] = matrix[by++][bx--];
            }
        } else { // 从A箭头到B箭头打印
            while (ay >= by) {
                res[index++] = matrix[ay--][ax++];
            }
        }
    }


    /*public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(Arrays.toString(findDiagonalOrder(m)));
    }*/
}
