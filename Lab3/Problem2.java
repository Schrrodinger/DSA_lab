import java.util.Stack;

public class Problem2 {

    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();
        Stack<Integer> values = new Stack<Integer>(); // Stack for numbers
        Stack<Character> ops = new Stack<Character>(); // Stack for operators

        for (int i = 0; i < tokens.length; i++) {
            // Skip whitespaces
            if (tokens[i] == ' ') {
                continue;
            }

            // If it's a number, read the full number (which can have multiple digits)
            if (tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                // There could be more than one digit in the number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    sb.append(tokens[i++]);
                }
                // We've found a non-digit, stepping back so we don't skip it in the next iteration
                i--;
                // Push the number onto the stack
                values.push(Integer.parseInt(sb.toString()));
            }
            // If it's an opening brace, push it to 'ops'
            else if (tokens[i] == '(') {
                ops.push(tokens[i]);
            }
            // Closing brace encountered, solve the entire brace
            else if (tokens[i] == ')') {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }
            // If it's an operator
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // While the top of 'ops' has the same or greater precedence to current token,
                // which is an operator. Apply the operator on top of 'ops' to the top two elements in values stack
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                // Push current token to 'ops'
                ops.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining 'ops' to 'values'
        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        // Top of 'values' contains the result, return it
        return values.pop();
    }

    // Returns true if 'op2' has higher or the same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) {
            return false;
        }
        return true;
    }

    // A utility method to apply an operator 'op' on operands 'a' and 'b'.
    // Return the result.
    public static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    // Main method to test the expression evaluation
    public static void main(String[] args) {
        System.out.println(Problem2.evaluate("10 + 2 * 6"));
        System.out.println(Problem2.evaluate("100 * 2 + 12"));
        System.out.println(Problem2.evaluate("100 * ( 2 + 12 )"));
        System.out.println(Problem2.evaluate("100 * ( 2 + 12 ) / 07"));
    }
}
