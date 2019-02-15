/*
Author  : Michael Borden
Date    : Feb 14, 2019
Update  : Feb 14, 2019

Purpose : Write a programt to evaluate arithmetical expressions that use + and * applied to nonnegative integer arguments. Expressions are in reverse-Polish notation, e.g., 3 4 + 5 *, 1 3 + 5 7 + *.
*/
import java.util.Stack;
import java.util.Scanner;

class reversePolishNotation {

    public static int reversePolishNotation(String notation) {
        Stack<String> rpn = stringToStack(notation);
        return reversePolishNotation(rpn);
    }
    
    public static int reversePolishNotation(Stack notation) {
        Stack<Integer> vars = new Stack<>();
        Stack<String> ops = new Stack<>();
        String c;
        int buff = 0;
        boolean twoVars;
        while(!notation.empty()) {
            twoVars = (vars.size() > 1) ? true : false;
            if (isInteger((String) notation.peek()))
                c = (String) notation.pop();
            else if (ops.empty() && twoVars)
                c = (String) ops.pop();
            else    
                c = (String) notation.pop();
            switch (c) {
                case "+":
                    if (twoVars) {
                        buff = vars.pop() + vars.pop();
                        vars.push(buff);
                    }
                    else
                        ops.push(c);
                    break;
                case "*": 
                    if (twoVars) {
                        buff = vars.pop() * vars.pop();
                        vars.push(buff);
                    }
                    else
                        ops.push(c);
                    break;
                default:
                    vars.push(Integer.parseInt(c));
            }
        }
        return buff;
    }
    
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    public static Stack stringToStack(String S) {
        Stack<String> stack = new Stack<>();
        Scanner scanner = new Scanner(S);
        while (scanner.hasNext()) {
            if (scanner.hasNextInt())
                stack.push(Integer.toString(scanner.nextInt()));
            else
                stack.push(scanner.next());
        }
        scanner.close();
        return stack;
    }

    public static void main(String[] args) {
        String        rpn1 = "3 4 + 5 *";
        Stack<String> rpn2 = new Stack<>();
        rpn2.push("1"); rpn2.push("2"); rpn2.push("+"); rpn2.push("5");
        rpn2.push("7"); rpn2.push("+"); rpn2.push("*");
        int out1 = reversePolishNotation(rpn1);
        int out2 = reversePolishNotation(rpn2);
        assert out1 == 35: "reversePolishNotation(): Fail";
        assert out2 == 36: "reversePolishNotation(): Fail";
        System.out.println("reversePolishNotation(): Pass");
    }
}
