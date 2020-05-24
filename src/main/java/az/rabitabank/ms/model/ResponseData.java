package az.rabitabank.ms.model;


import java.util.StringJoiner;

public class ResponseData {

    private int result;

    public ResponseData() { }

    public ResponseData(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseData.class.getSimpleName() + "[", "]")
                .add("result=" + result)
                .toString();
    }
}
