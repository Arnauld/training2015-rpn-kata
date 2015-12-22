package com.arolla.training.rpn;

import java.util.List;

public class RpnCalculator {

    public static final MyToken PLUS = new MyToken("+");
    public static final MyToken MULT = new MyToken("*");
    public static final MyToken SUBSTRACT = new MyToken("-");
    public static final MyToken DIVIDE = new MyToken("/");

    private final OperatorRegistry operatorRegistry;

    public RpnCalculator() {
        this(new OperatorRegistry().initDefaultOperators());
    }
    public RpnCalculator(OperatorRegistry registry) {
        this.operatorRegistry = registry;
    }

    public List<Integer> evaluate(String rpnExpression) {
        MyParser parser = new MyParser();
        MyTokens tokens = parser.parse(rpnExpression);

        MyStack stack = new MyStack();
        for (MyToken token : tokens) {
            evaluateToken(stack, token);
        }
        return stack.toList();
    }

    private void evaluateToken(MyStack stack, MyToken token) {
        if (token.isInteger()) {
            int value = token.toInt();
            stack.push(value);
            return;
        }

        MyOperation operation = operatorRegistry.get(token);
        if (operation == null)
            throw new IllegalArgumentException("Cannot process operation, reason: operator unknown.");

        if (stack.size() < 2) {
            throw new IllegalArgumentException("Cannot process operation, reason: operand missing.");
        }
        int secondOperand = stack.pop();
        int firstOperand = stack.pop();
        int result = operation.evaluate(firstOperand, secondOperand);
        stack.push(result);
    }

}
