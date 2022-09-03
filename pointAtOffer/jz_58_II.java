package pointAtOffer;

/**
 * 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 * 思路：三次反转
 */
public class jz_58_II {
    public String reverseLeftWords(String s, int n) {
        char[] chas = s.toCharArray();
        reverse(chas, 0, n - 1);
        reverse(chas, n, chas.length - 1);
        reverse(chas, 0, chas.length - 1);
        return String.valueOf(chas);
    }

    public void reverse(char[] chas, int l, int r) {
        while (l < r) {
            char temp = chas[l];
            chas[l] = chas[r];
            chas[r] = temp;
            l++;
            r--;
        }
    }
}
