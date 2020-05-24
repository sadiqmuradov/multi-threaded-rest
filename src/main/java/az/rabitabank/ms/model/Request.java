package az.rabitabank.ms.model;

import java.util.StringJoiner;

public class Request {

    private int a;
    private int b;

    public Request() { }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Request.class.getSimpleName() + "[", "]")
                .add("a=" + a)
                .add("b=" + b)
                .toString();
    }
}
