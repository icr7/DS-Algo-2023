package com.dsAlgo2023.Mohit_DSA;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class March {
    public static void main(String[] args) {
        System.out.println(validParanthesis("([][]){}"));
    }

    private static boolean validParanthesis(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {//commmit 2
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch); // commmit 1
            } else {
                if (!stack.isEmpty() && stack.peek() == map.get(ch)) {
                    stack.pop(); //commmit 3
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
