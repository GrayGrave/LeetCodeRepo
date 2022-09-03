package pointAtOffer;

/**
 * 替换空格
 */
public class jz_05 {
    public String replaceSpace(String s) {
        if (s == null) return null;

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return new String(sb);
    }
}
