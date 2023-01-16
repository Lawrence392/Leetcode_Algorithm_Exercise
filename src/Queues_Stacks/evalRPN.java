package Queues_Stacks;

import java.util.Stack;

public class evalRPN {
    public static void main(String[] args) {
        // String[] tokens = {"4","13","5","/","+"};
        String[] tokens = {"2","1","+","3","*"};

        System.out.println(Solution(tokens));
    }



    public static int Solution(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();
        int num1;
        int num2;
        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i].equals("+")){
                stack.push(stack.pop() + stack.pop());}
            else if(tokens[i].equals("-")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);}
            else if(tokens[i].equals("*")){
                stack.push(stack.pop() * stack.pop());}
            else if(tokens[i].equals("/")){
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            }
            else stack.push(Integer.parseInt(tokens[i]));
        }

        return stack.pop();
    }
}