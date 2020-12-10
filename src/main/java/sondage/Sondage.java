package sondage;

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
    private int sondId;

    @Column(name = "description", nullable = false)
    private String description;


}

