package Queues_Stacks;

import java.util.Stack;

public class isValid {
    public static void main(String[] args) {
        
        String string = "{[]}";
        
        System.out.println(Solution(string));
    }
    public static boolean Solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        char ch;
        for (int i = 0; i < len; i++) {
            ch = s.charAt(i);

            if(ch == '{' || ch == '[' || ch == '(')
            {
                if(ch == '{' ) stack.push('}');
                if(ch == '[' ) stack.push(']');
                if(ch == '(' ) stack.push(')');
            }else{
                if(stack.isEmpty()){
                    return false;
                }else
                if (ch != stack.pop()) {
                    return false;
                }
            }
        }
        // 检查是否全部弹出
        if(stack.isEmpty()){
            return true;
        }else return false;
    }
}

