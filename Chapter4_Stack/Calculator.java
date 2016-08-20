package Chapter4_Stack;

import java.util.Scanner;
import java.util.Stack;
/*
 * 
 * 前缀 (PN) or Reverse Polish Notation  (后缀RPN)表达式.
 */
public class Calculator {
      public static final String USAGE = "== usage ==\n"
            + "input the expressions, and then the program "
            + "will calculate them and show the result.\n"
            + "input 'bye' to exit.\n";
      /*
       * @param args
       */
      public static void main(String[] args) {
            System.out.println(USAGE);
            Scanner scanner = new Scanner(System.in);
            String input = "";
            final String CLOSE_MARK = "bye";
            System.out.println("input an expression:");
            input = scanner.nextLine();
            while (input.length() != 0
                  && !CLOSE_MARK.equals((input))) {
                  System.out.print("Polish Notation (PN):");
                  try {
                        toPolishNotation(input);
                  } catch (NumberFormatException e) {
                        System.out.println("\ninput error, not a number.");
                  } catch (IllegalArgumentException e) {
                        System.out.println("\ninput error:" + e.getMessage());
                  } catch (Exception e) {
                        System.out.println("\ninput error, invalid expression.");
                  }
                  System.out.print("Reverse Polish Notation (RPN):");
                  try {
                        toReversePolishNotation(input);
                  } catch (NumberFormatException e) {
                        System.out.println("\ninput error, not a number.");
                  } catch (IllegalArgumentException e) {
                        System.out.println("\ninput error:" + e.getMessage());
                  } catch (Exception e) {
                        System.out.println("\ninput error, invalid expression.");
                  }
                  System.out.println("input a new expression:");
                  input = scanner.nextLine();
            }
            System.out.println("program exits");
      }
      /*
       * parse the expression , and calculate it.
       * @param input
       * @throws IllegalArgumentException
       * @throws NumberFormatException
       */
      private static void toPolishNotation(String input)
                  throws IllegalArgumentException, NumberFormatException {
            int len = input.length();
            char c, tempChar;
            Stack<Character> s1 = new Stack<Character>();
            Stack<Double> s2 = new Stack<Double>();
            Stack<Object> expression = new Stack<Object>();
            double number;
            int lastIndex = -1;
            for (int i=len-1; i>=0; --i) {
                  c = input.charAt(i);
                  if (Character.isDigit(c)) {
                        lastIndex = readDoubleReverse(input, i);
                        number = Double.parseDouble(input.substring(lastIndex, i+1));
                        s2.push(number);
                        i = lastIndex;
                        if ((int) number == number)
                              expression.push((int) number);
                        else
                              expression.push(number);
                  } else if (isOperator(c)) {
                        while (!s1.isEmpty()
                                    && s1.peek() != ')'
                                    && priorityCompare(c, s1.peek()) < 0) {
                              expression.push(s1.peek());
                              s2.push(calc(s2.pop(), s2.pop(), s1.pop()));
                        }
                        s1.push(c);
                  } else if (c == ')') {
                        s1.push(c);
                  } else if (c == '(') {
                        while ((tempChar=s1.pop()) != ')') {
                              expression.push(tempChar);
                              s2.push(calc(s2.pop(), s2.pop(), tempChar));
                              if (s1.isEmpty()) {
                                    throw new IllegalArgumentException(
                                          "bracket dosen't match, missing right bracket ')'.");
                              }
                        }
                  } else if (c == ' ') {
                        // ignore
                  } else {
                        throw new IllegalArgumentException(
                                    "wrong character '" + c + "'");
                  }
            }
            while (!s1.isEmpty()) {
                  tempChar = s1.pop();
                  expression.push(tempChar);
                  s2.push(calc(s2.pop(), s2.pop(), tempChar));
            }
            while (!expression.isEmpty()) {
                  System.out.print(expression.pop() + " ");
            }
            double result = s2.pop();
            if (!s2.isEmpty())
                  throw new IllegalArgumentException("input is a wrong expression.");
            System.out.println();
            if ((int) result == result)
                  System.out.println("the result is " + (int) result);
            else
                  System.out.println("the result is " + result);
      }
      /*
       * parse the expression, and calculate it.
       * @param input
       * @throws IllegalArgumentException
       * @throws NumberFormatException
       */
      private static void toReversePolishNotation(String input)
                  throws IllegalArgumentException, NumberFormatException {
            int len = input.length();
            char c, tempChar;
            Stack<Character> s1 = new Stack<Character>();
            Stack<Double> s2 = new Stack<Double>();
            double number;
            int lastIndex = -1;
            for (int i=0; i<len; ++i) {
                  c = input.charAt(i);
                  if (Character.isDigit(c) || c == '.') {
                        lastIndex = readDouble(input, i);
                        number = Double.parseDouble(input.substring(i, lastIndex));
                        s2.push(number);
                        i = lastIndex - 1;
                        if ((int) number == number)
                              System.out.print((int) number + " ");
                        else
                              System.out.print(number + " ");
                  } else if (isOperator(c)) {
                        while (!s1.isEmpty()
                                    && s1.peek() != '('
                                    && priorityCompare(c, s1.peek()) <= 0) {
                              System.out.print(s1.peek() + " ");
                              double num1 = s2.pop();
                              double num2 = s2.pop();
                              s2.push(calc(num2, num1, s1.pop()));
                        }
                        s1.push(c);
                  } else if (c == '(') {
                        s1.push(c);
                  } else if (c == ')') {
                        while ((tempChar=s1.pop()) != '(') {
                              System.out.print(tempChar + " ");
                              double num1 = s2.pop();
                              double num2 = s2.pop();
                              s2.push(calc(num2, num1, tempChar));
                              if (s1.isEmpty()) {
                                    throw new IllegalArgumentException(
                                          "bracket dosen't match, missing left bracket '('.");
                              }
                        }
                  } else if (c == ' ') {
                        // ignore
                  } else {
                        throw new IllegalArgumentException(
                                    "wrong character '" + c + "'");
                  }
            }
            while (!s1.isEmpty()) {
                  tempChar = s1.pop();
                  System.out.print(tempChar + " ");
                  double num1 = s2.pop();
                  double num2 = s2.pop();
                  s2.push(calc(num2, num1, tempChar));
            }
            double result = s2.pop();
            if (!s2.isEmpty())
                  throw new IllegalArgumentException("input is a wrong expression.");
            System.out.println();
            if ((int) result == result)
                  System.out.println("the result is " + (int) result);
            else
                  System.out.println("the result is " + result);
      }
      /*
       * calculate the two number with the operation.
       * @param num1
       * @param num2
       * @param op
       * @return
       * @throws IllegalArgumentException
       */
      private static double calc(double num1, double num2, char op)
                  throws IllegalArgumentException {
            switch (op) {
            case '+':
                  return num1 + num2;
            case '-':
                  return num1 - num2;
            case '*':
                  return num1 * num2;
            case '/':
                  if (num2 == 0) throw new IllegalArgumentException("divisor can't be 0.");
                  return num1 / num2;
            default:
                  return 0; // will never catch up here
            }
      }
      /*
       * compare the two operations' priority.
       * @param c
       * @param peek
       * @return
       */
      private static int priorityCompare(char op1, char op2) {
            switch (op1) {
            case '+': case '-':
                  return (op2 == '*' || op2 == '/' ? -1 : 0);
            case '*': case '/':
                  return (op2 == '+' || op2 == '-' ? 1 : 0);
            }
            return 1;
      }
      /*
       * read the next number (reverse)
       * @param input
       * @param start
       * @return
       * @throws IllegalArgumentException
       */
      private static int readDoubleReverse(String input, int start)
                  throws IllegalArgumentException {
            int dotIndex = -1;
            char c;
            for (int i=start; i>=0; --i) {
                  c = input.charAt(i);
                  if (c == '.') {
                        if (dotIndex != -1)
                              throw new IllegalArgumentException(
                                    "there have more than 1 dots in the number.");
                        else
                              dotIndex = i;
                  } else if (!Character.isDigit(c)) {
                        return i + 1;
                  } else if (i == 0) {
                        return 0;
                  }
            }
            throw new IllegalArgumentException("not a number.");
      }
      
      /*
       * read the next number
       * @param input
       * @param start
       * @return
       * @throws IllegalArgumentException
       */
      private static int readDouble(String input, int start)
      throws IllegalArgumentException {
            int len = input.length();
            int dotIndex = -1;
            char c;
            for (int i=start; i<len; ++i) {
                  c = input.charAt(i);
                  if (c == '.') {
                        if (dotIndex != -1)
                              throw new IllegalArgumentException(
                              "there have more than 1 dots in the number.");
                        else if (i == len - 1)
                              throw new IllegalArgumentException(
                              "not a number, dot can't be the last part of a number.");
                        else
                              dotIndex = i;
                  } else if (!Character.isDigit(c)) {
                        if (dotIndex == -1 || i - dotIndex > 1)
                              return i;
                        else
                              throw new IllegalArgumentException(
                              "not a number, dot can't be the last part of a number.");
                  } else if (i == len - 1) {
                        return len;
                  }
            }
            
            throw new IllegalArgumentException("not a number.");
      }
      /*
       * return true if the character is an operator.
       * @param c
       * @return
       */
      private static boolean isOperator(char c) {
            return (c=='+' || c=='-' || c=='*' || c=='/');
      }
}