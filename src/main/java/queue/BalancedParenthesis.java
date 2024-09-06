package queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BalancedParenthesis {

    public boolean balanced(String input) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < input.length(); i++) {
            char x = input.charAt(i);

            if (List.of('(', '[', '{').contains(x)) {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // If current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        // Check Empty Stack
        return (stack.isEmpty());
    }
}
