package com.arolla.training.rpn;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class DivideOperation implements MyOperation {
    @Override
    public int evaluate(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
