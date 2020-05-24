package az.rabitabank.ms.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Clob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Data
@NoArgsConstructor
@Entity
@Table(name = "request_response_log")
public class RequestResponseLogEntity {

    @Id
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "seq_request_response_log")
//    @SequenceGenerator(sequenceName = "seq_request_response_log", allocationSize = 1, name = "seq_request_response_log")
    private Long id;

    @CreationTimestamp
    private LocalDateTime insertDate;

    @Lob
    private Clob value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentId", nullable = false)
    InitialRequestLogEntity initialRequest;

    public RequestResponseLogEntity(Clob value, InitialRequestLogEntity initialRequest) {
        this.value = value;
        this.initialRequest = initialRequest;
    }

    @Override
    public String toString() {
        StringJoiner joiner =
                new StringJoiner(", ", RequestResponseLogEntity.class.getSimpleName() + "[", "]")
                        .add("id=" + id)
                        .add("insertDate=" + insertDate);

        String result = joiner.toString();

        try {
            result = joiner.add("value=" + value.getSubString(1, (int) value.length())).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
