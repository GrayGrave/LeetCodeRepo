package ac.matrixPath;

/**
 * 蛇行打印矩阵
 * 思路:拆解为多条不同方向的斜线，定位斜线的起始点进行打印即可
 * 矩阵处理技巧：找到编码上的宏观调度 => 相关题目：1）转圈打印矩阵、2）原地旋转正方形矩形（LC_48）
 * 1）解题思路：左上角和右下角两个点构成一圈，两点往中间收缩，每次打印一圈
 */
public class ZigZagPrintMatrix {
    public static void zigZagPrintMatrix(int[][] matrix) {
        int Ax = 0, Ay = 0;         // A箭头负责矩阵左下部分的移动
        int Bx = 0, By = 0;         // B箭头负责矩阵右上部分的移动，箭头A、B会在矩阵右下角碰头，因为走的步数一样多
        int Endx = matrix[0].length - 1;
        int Endy = matrix.length - 1;
        boolean fromUp = false;    // 是否是从右上往左下打印
        while (By <= Endy + 1) {
            printLevel(matrix, Ax, Ay, Bx, By, fromUp);
            // A箭头先下后右    此处有坑：注意两排顺序，交换顺序打印会出错
            Ax = Ay == Endy ? Ax + 1 : Ax;
            Ay = Ay == Endy ? Ay : Ay + 1;

            // B箭头先右后下
            By = Bx == Endx ? By + 1 : By;
            Bx = Bx == Endx ? Bx : Bx + 1;

            fromUp = !fromUp;          // 调整打印方向
            System.out.println();
        }
    }

    // 打印两点连线的数字
    private static void printLevel(int[][] matrix, int ax, int ay, int bx, int by, boolean fromUp) {
        if (fromUp) {  // 从B箭头到A箭头打印
            while (by <= ay) {
                System.out.print(matrix[by++][bx--] + " ");
            }
        } else { // 从A箭头到B箭头打印
            while (ay >= by) {
                System.out.print(matrix[ay--][ax++] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        zigZagPrintMatrix(m);
    }
}
