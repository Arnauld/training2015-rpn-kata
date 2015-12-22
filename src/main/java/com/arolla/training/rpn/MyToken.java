package com.arolla.training.rpn;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public class MyToken {
    private final String token;

    public MyToken(String token) {
        this.token = token;
    }

    public boolean isInteger() {
        try {
            Integer.parseInt(token);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public int toInt() {
        return Integer.parseInt(token);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyToken myToken = (MyToken) o;
        return token.equals(myToken.token);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }
}
