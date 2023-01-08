package Other;
// https://leetcode.cn/problems/reverse-words-in-a-string-iii/submissions/
// 输入：
// "Let's take LeetCode contest"
// 输出：
// "s'teL ekat edoCteeL tsetnoc"


public class reverseWordIII {
    public static String reverseWords(String s) {

        int length = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && chars[i] != ' ') {
                i++;
            }

            int left = start, right = i - 1;
            char temp = ' ';
            while (left < right) {
                temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            while (i < length && chars[i] == ' ') {
                i++;
            }
        }
        s = String.copyValueOf(chars);
        return s;
    }
    
    // s = new StringBuffer(s).reverse().toString();
    
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        s = reverseWords(s);
        System.out.println(s);
    }
}
