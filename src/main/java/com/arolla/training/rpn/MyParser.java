package com.arolla.training.rpn;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class MyParser {
    public MyTokens parse(String rpnExpression) {
        String[] tokens = rpnExpression.split(" ");
        return new MyTokens(tokens);
    }
}
