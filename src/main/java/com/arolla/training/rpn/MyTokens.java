package com.arolla.training.rpn;

import java.util.Iterator;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class MyTokens implements Iterable<MyToken> {
    private final String[] tokens;

    public MyTokens(String[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public Iterator<MyToken> iterator() {
        return new Iterator<MyToken>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index<tokens.length;
            }

            @Override
            public MyToken next() {
                return new MyToken(tokens[index++]);
            }
        };
    }
}
