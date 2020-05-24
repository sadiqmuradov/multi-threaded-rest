package az.rabitabank.ms.config;

import az.rabitabank.ms.logger.MainLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;

@Configuration
public class CalculatorSoapConfig {

    private static final MainLogger LOGGER = MainLogger.getLogger(CalculatorSoapConfig.class);

    private java.net.URL wsdlUrl;

    {
        try {
            this.wsdlUrl = new java.net.URL("http://www.dneonline.com/calculator.asmx?wsdl");
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /*@PostConstruct
    public void setWsdlUrl() {
        try {
            this.wsdlUrl = new java.net.URL("http://www.dneonline.com/calculator.asmx?wsdl");
        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }*/

    @Bean
    public CalculatorSoap port() {
        Calculator calculator = new Calculator(wsdlUrl);
        CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();

        return calculatorSoap;
    }

}
