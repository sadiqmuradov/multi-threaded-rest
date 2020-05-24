package az.rabitabank.ms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.StringJoiner;

@Data
@NoArgsConstructor
@Entity
@Table(name = "initial_request_log")
public class InitialRequestLogEntity {

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_initial_request_log")
//    @SequenceGenerator(sequenceName = "seq_initial_request_log", allocationSize = 1, name = "seq_initial_request_log")
    private Long id;

    @CreationTimestamp
    private LocalDateTime insertDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "initialRequest", fetch = FetchType.LAZY)
    private List<RequestResponseLogEntity> requestResponseLogs;

    @Override
    public String toString() {
        return new StringJoiner(", ", InitialRequestLogEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("insertDate=" + insertDate)
                .add("requestResponseLogs=" + requestResponseLogs)
                .toString();
    }
}
