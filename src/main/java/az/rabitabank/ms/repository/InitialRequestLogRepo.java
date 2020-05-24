package az.rabitabank.ms.repository;

import az.rabitabank.ms.entity.InitialRequestLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InitialRequestLogRepo extends JpaRepository<InitialRequestLogEntity, Long> {

}
