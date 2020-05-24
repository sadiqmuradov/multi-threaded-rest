package az.rabitabank.ms.service;

import az.rabitabank.ms.client.CalculatorSoapClient;
import az.rabitabank.ms.constants.ResultCode;
import az.rabitabank.ms.entity.InitialRequestLogEntity;
import az.rabitabank.ms.entity.RequestResponseLogEntity;
import az.rabitabank.ms.logger.MainLogger;
import az.rabitabank.ms.model.OperationResponse;
import az.rabitabank.ms.model.Request;
import az.rabitabank.ms.model.ResponseData;
import az.rabitabank.ms.repository.InitialRequestLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.SQLException;


@Service
public class MainService implements IMainService {

    private static final MainLogger LOGGER = MainLogger.getLogger(MainService.class);

    private static final String SUCCESS = "Successfully completed";

    @Autowired
    private CalculatorSoapClient soapClient;

    @Autowired
    DataSource dataSource;

    @Override
    public OperationResponse add(int a, int b, InitialRequestLogEntity requestLog) {
        OperationResponse operationResponse = new OperationResponse(ResultCode.ERROR);

        try {
            LOGGER.info("Add. Request to SOAP: {}, {}", a, b);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Add. Request to SOAP: " + a + ", " + b);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int result = soapClient.add(a, b);

            LOGGER.info("Add. Response from SOAP: {}", result);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Add. Response from SOAP: " + result);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResponseData responseData = new ResponseData(result);

            operationResponse.setCode(ResultCode.OK);
            operationResponse.setMessage(SUCCESS);
            operationResponse.setData(responseData);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            operationResponse.setMessage(e.getMessage().trim());
        }

        return operationResponse;
    }

    @Override
    public OperationResponse subtract(int a, int b, InitialRequestLogEntity requestLog) {
        OperationResponse operationResponse = new OperationResponse(ResultCode.ERROR);

        try {
            LOGGER.info("Subtract. Request to SOAP: {}, {}", a, b);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Subtract. Request to SOAP: " + a + ", " + b);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int result = soapClient.subtract(a, b);

            LOGGER.info("Subtract. Response from SOAP: {}", result);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Subtract. Response from SOAP: " + result);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResponseData responseData = new ResponseData(result);

            operationResponse.setCode(ResultCode.OK);
            operationResponse.setMessage(SUCCESS);
            operationResponse.setData(responseData);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            operationResponse.setMessage(e.getMessage().trim());
        }

        return operationResponse;
    }

    @Override
    public OperationResponse multiply(int a, int b, InitialRequestLogEntity requestLog) {
        OperationResponse operationResponse = new OperationResponse(ResultCode.ERROR);

        try {
            LOGGER.info("Multiply. Request to SOAP: {}, {}", a, b);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Multiply. Request to SOAP: " + a + ", " + b);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int result = soapClient.multiply(a, b);

            LOGGER.info("Multiply. Response from SOAP: {}", result);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Multiply. Response from SOAP: " + result);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResponseData responseData = new ResponseData(result);

            operationResponse.setCode(ResultCode.OK);
            operationResponse.setMessage(SUCCESS);
            operationResponse.setData(responseData);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            operationResponse.setMessage(e.getMessage().trim());
        }

        return operationResponse;
    }

    @Override
    public OperationResponse divide(int a, int b, InitialRequestLogEntity requestLog) {
        OperationResponse operationResponse = new OperationResponse(ResultCode.ERROR);

        try {
            LOGGER.info("Divide. Request to SOAP: {}, {}", a, b);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Divide. Request to SOAP: " + a + ", " + b);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            int result = soapClient.divide(a, b);

            LOGGER.info("Divide. Response from SOAP: {}", result);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Divide. Response from SOAP: " + result);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            ResponseData responseData = new ResponseData(result);

            operationResponse.setCode(ResultCode.OK);
            operationResponse.setMessage(SUCCESS);
            operationResponse.setData(responseData);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            operationResponse.setMessage(e.getMessage().trim());
        }

        return operationResponse;
    }

}
