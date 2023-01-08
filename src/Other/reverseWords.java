package Other;
// https://leetcode.cn/problems/reverse-words-in-a-string/
// 颠倒字符串中的单词
// 输入：s = "the sky is blue"
// 输出："blue is sky the"
// 输入：s = "  hello world  "
// 输出："world hello"
// 解释：颠倒后的字符串中不能存在前导空格和尾随空格。

import java.util.Arrays;
import java.util.Stack;

public class reverseWords {
    // 最快的方式
    public static String reverseWords1(String s) {
        int N = s.length();
        int i = 0, j = 0;
        char[] scr = s.toCharArray();
        char temp = ' ';
        //  去除多余空格
        while (i < N)
        {
            while (i < N && scr[i] == ' ')
            {
                i++;
            }
            while (i < N && scr[i] != ' ')
            {
                temp = scr[i];
                scr[i] = scr[j];
                scr[j] = temp;
                i++;
                j++;
            }
            j = j + 1;
        }


        N = s.length()-1;
        while (scr[N] == ' ')
        {
            N--;
        }


        char[] string = Arrays.copyOf(scr, N+1);
        String strStringType = String.valueOf(string);

        s = new StringBuilder(strStringType).reverse().toString();
        scr = s.toCharArray();
        int start = 0, end = 0, tmp;
        while (start < N)
        {
            while (end < N && scr[end] != ' ')
            {
                end++;
            }
            tmp = scr[end] == ' ' ? end - 1 : end;
            while (start < tmp)
            {
                temp = scr[start];
                scr[start] = scr[tmp];
                scr[tmp] = temp;
                start++;
                tmp--;
            }
            start = end + 1;
            end = start;
        }
        s = String.valueOf(scr);
        return s;
    }
// 使用栈
    public static String reverseWords2(String s) {
        // 按照空格分割字符串
        String[] strings = s.split(" ");
        // 将单词入栈,去除空格
        Stack<String> stack = new Stack<String>();
        for (String string : strings) {
            
            if(string.equals(""))
            {
                continue;
            }
            stack.push(string);
        }
        // 创建字符串数组,接受逆序单词
        String[] newstrings = new String[stack.size()];
        for (int i = 0; i < newstrings.length; i++) {
            newstrings[i] = stack.pop();
        }
        // 单词间使用空格分隔
        s = String.join(" ",newstrings);
        return s;
    }
    
    
    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords2(s));
    }
}
