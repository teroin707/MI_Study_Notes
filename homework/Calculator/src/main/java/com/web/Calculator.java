package com.web;

import java.util.*;
import java.util.regex.*;

public class Calculator {

    // 运算符优先级
    private static final Map<Character, Integer> precedence = new HashMap<>();
    static {
        precedence.put('+', 1);
        precedence.put('-', 1);
        precedence.put('*', 2);
        precedence.put('/', 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入计算式（例如 3 + 5 * ( 2 - 8 )）：");
        String input = scanner.nextLine();

        try {
            List<String> postfix = infixToPostfix(input);
            System.out.println("后缀表达式：" + postfix);
            double result = evaluatePostfix(postfix);
            System.out.println("结果是：" + result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("无效的计算式");
        }
    }

    // 将中缀表达式转换为后缀表达式
    private static List<String> infixToPostfix(String infix) throws Exception {
        List<String> output = new ArrayList<>();
        Stack<Character> operators = new Stack<>();
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*|\\.\\d+|[+\\-*/()]");
        Matcher matcher = pattern.matcher(infix.replaceAll("\\s+", "")); // 移除所有空格

        while (matcher.find()) {
            String token = matcher.group();
            char ch = token.charAt(0);

            if (Character.isDigit(ch) || (ch == '.' && token.length() > 1)) {
                output.add(token);
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                if (!operators.isEmpty() && operators.peek() == '(') {
                    operators.pop(); // 弹出 '('
                } else {
                    throw new Exception("括号不匹配");
                }
            } else if (precedence.containsKey(ch)) {
                while (!operators.isEmpty() && precedence.get(operators.peek()) != null
                        && precedence.get(operators.peek()) >= precedence.get(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            } else {
                throw new Exception("无效的字符: " + ch);
            }
        }

        while (!operators.isEmpty()) {
            char op = operators.pop();
            if (op == '(' || op == ')') {
                throw new Exception("括号不匹配");
            }
            output.add(String.valueOf(op));
        }

        return output;
    }

    // 计算后缀表达式
    private static double evaluatePostfix(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+\\.?\\d*|\\.\\d+")) {
                stack.push(Double.valueOf(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        return stack.pop();
    }
}
