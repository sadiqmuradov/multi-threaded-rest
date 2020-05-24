package az.rabitabank.ms.service;


import az.rabitabank.ms.entity.InitialRequestLogEntity;
import az.rabitabank.ms.model.OperationResponse;

public interface IMainService {

    OperationResponse add(int intA, int intB, InitialRequestLogEntity requestLogEntity);
    OperationResponse subtract(int intA, int intB, InitialRequestLogEntity requestLogEntity);
    OperationResponse multiply(int intA, int intB, InitialRequestLogEntity requestLogEntity);
    OperationResponse divide(int intA, int intB, InitialRequestLogEntity requestLogEntity);

}
