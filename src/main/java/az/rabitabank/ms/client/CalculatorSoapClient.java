package az.rabitabank.ms.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tempuri.CalculatorSoap;

@Service
public class CalculatorSoapClient {

    @Autowired
    private CalculatorSoap port;

    public int add(int a, int b) {
        return port.add(a, b);
    }

    public int subtract(int a, int b) {
        return port.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return port.multiply(a, b);
    }

    public int divide(int a, int b) {
        return port.divide(a, b);
    }

}
