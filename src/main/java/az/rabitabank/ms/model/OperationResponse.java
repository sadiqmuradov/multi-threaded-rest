package az.rabitabank.ms.model;

import az.rabitabank.ms.constants.ResultCode;

import java.util.StringJoiner;

public class OperationResponse {

    private ResultCode code;
    private String message;
    private ResponseData data;

    public OperationResponse() { }

    public OperationResponse(ResultCode code) {
        this.code = code;
    }

    public ResultCode getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseData getData() {
        return data;
    }

    public void setData(ResponseData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", OperationResponse.class.getSimpleName() + "[", "]")
                .add("code=" + code)
                .add("message='" + message + "'")
                .add("data=" + data)
                .toString();
    }
}
