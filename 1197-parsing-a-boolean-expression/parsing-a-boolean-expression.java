class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : expression.toCharArray()) {
            if (ch == ',') continue;
            if (ch != ')') {
                stack.push(ch);
            } else {
                List<Character> vals = new ArrayList<>();
                while (stack.peek() != '(') {
                    vals.add(stack.pop());
                }
                stack.pop();
                char op = stack.pop();
                if (op == '&') {
                    stack.push(vals.contains('f') ? 'f' : 't');
                } else if (op == '|') {
                    stack.push(vals.contains('t') ? 't' : 'f');
                } else {
                    stack.push(vals.get(0) == 't' ? 'f' : 't');
                }
            }
        }
        return stack.pop() == 't';
    }
}
