package com.arolla.training.rpn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class OperatorRegistry {
    public static final MyToken PLUS = new MyToken("+");
    public static final MyToken MULT = new MyToken("*");
    public static final MyToken SUBSTRACT = new MyToken("-");
    public static final MyToken DIVIDE = new MyToken("/");

    private Map<MyToken, MyOperation> operations = new HashMap<>();

    public OperatorRegistry() {
    }

    public OperatorRegistry initDefaultOperators() {
        operations.put(PLUS, new AddOperation());
        operations.put(MULT, new MultOperation());
        operations.put(SUBSTRACT, new SubstractOperation());
        operations.put(DIVIDE, new DivideOperation());
        return this;
    }

    public MyOperation get(MyToken token) {
        return operations.get(token);
    }


    public void register(MyToken myToken, MyOperation myOperation) {
        operations.put(myToken, myOperation);
    }
}
