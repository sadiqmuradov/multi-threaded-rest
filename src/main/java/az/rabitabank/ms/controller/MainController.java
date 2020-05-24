package az.rabitabank.ms.controller;

import az.rabitabank.ms.constants.URL;
import az.rabitabank.ms.entity.InitialRequestLogEntity;
import az.rabitabank.ms.entity.RequestResponseLogEntity;
import az.rabitabank.ms.logger.MainLogger;
import az.rabitabank.ms.model.Request;
import az.rabitabank.ms.model.OperationResponse;
import az.rabitabank.ms.repository.InitialRequestLogRepo;
import az.rabitabank.ms.service.MainService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;

@RestController
@CrossOrigin
@Validated
@Api("RabitaBank Multi-Threaded Calculator Rest Api")
public class MainController {

    private static final MainLogger LOGGER = MainLogger.getLogger(MainController.class);

    @Autowired
    private MainService mainService;

    @Autowired
    private InitialRequestLogRepo requestLogRepo;

    @Autowired
    DataSource dataSource;

    @ApiOperation("Add two integers")
    @PostMapping(URL.ADD)
    public OperationResponse add(@RequestBody final Request request) {
        synchronized (LOGGER) {
            LOGGER.info("Add. Request to JSON : {}", request);

            InitialRequestLogEntity requestLog = new InitialRequestLogEntity();
            requestLog.setRequestResponseLogs(new ArrayList<>());

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Add. Request to JSON : " + request);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            OperationResponse response = mainService.add(request.getA(), request.getB(), requestLog);

            LOGGER.info("Add. Response from JSON: {}", response);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Add. Response from JSON: " + response);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            requestLogRepo.save(requestLog);

            return response;
        }
    }

    @ApiOperation("Subtract two integers")
    @PostMapping(URL.SUBTRACT)
    public OperationResponse subtract(@RequestBody final Request request) {
        synchronized (LOGGER) {
            LOGGER.info("Subtract. Request to JSON : {}", request);

            InitialRequestLogEntity requestLog = new InitialRequestLogEntity();
            requestLog.setRequestResponseLogs(new ArrayList<>());

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Subtract. Request to JSON : " + request);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            OperationResponse response = mainService.subtract(request.getA(), request.getB(), requestLog);

            LOGGER.info("Subtract. Response from JSON: {}", response);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Subtract. Response from JSON: " + response);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            requestLogRepo.save(requestLog);

            return response;
        }
    }

    @ApiOperation("Multiply two integers")
    @PostMapping(URL.MULTIPLY)
    public OperationResponse multiply(@RequestBody final Request request) {
        synchronized (LOGGER) {
            LOGGER.info("Multiply. Request to JSON : {}", request);

            InitialRequestLogEntity requestLog = new InitialRequestLogEntity();
            requestLog.setRequestResponseLogs(new ArrayList<>());

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Multiply. Request to JSON : " + request);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            OperationResponse response = mainService.multiply(request.getA(), request.getB(), requestLog);

            LOGGER.info("Multiply. Response from JSON: {}", response);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Multiply. Response from JSON: " + response);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            requestLogRepo.save(requestLog);

            return response;
        }
    }

    @ApiOperation("Divide two integers")
    @PostMapping(URL.DIVIDE)
    public OperationResponse divide(@RequestBody final Request request) {
        synchronized (LOGGER) {
            LOGGER.info("Divide. Request to JSON : {}", request);

            InitialRequestLogEntity requestLog = new InitialRequestLogEntity();
            requestLog.setRequestResponseLogs(new ArrayList<>());

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Divide. Request to JSON : " + request);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            OperationResponse response = mainService.divide(request.getA(), request.getB(), requestLog);

            LOGGER.info("Divide. Response from JSON: {}", response);

            try {
                Clob value = dataSource.getConnection().createClob();
                value.setString(1, "Divide. Response from JSON: " + response);
                requestLog.getRequestResponseLogs().add(new RequestResponseLogEntity(value, requestLog));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            requestLogRepo.save(requestLog);

            return response;
        }
    }
}
