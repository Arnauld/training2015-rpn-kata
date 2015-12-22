package com.arolla.training.rpn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class MyStack {

    private Stack<Integer> values = new Stack<>();

    public void push(int value) {
        values.push(value);
    }

    public int size() {
        return values.size();
    }

    public int pop() {
        return values.pop();
    }

    public List<Integer> toList() {
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(values);
        return result;
    }
}
