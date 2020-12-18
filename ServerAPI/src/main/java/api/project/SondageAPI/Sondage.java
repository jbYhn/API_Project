package api.project.SondageAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sondage")
@EntityListeners(AuditingEntityListener.class)
public class Sondage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    public int id;

    @Column(name = "user_id", nullable = false)
    public int user_id;

    @Column(name = "description", nullable = false)
    public String description;

    @Column(name = "lieu", nullable = false)
    public String lieu;

}
