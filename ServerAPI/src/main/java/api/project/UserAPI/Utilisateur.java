package api.project.UserAPI;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "utilisateur")
@EntityListeners(AuditingEntityListener.class)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
    public int id;

    @Column(name = "pasword", nullable = false)
    public String pasword;

    @Column(name = "name", nullable = false)
    public String name;

    @Column(name = "email", nullable = false)
    public String email;

    @GeneratedValue()
    @Column(name = "token", nullable = false)
    public String token;

    public void setToken(String token) {
        this.token = token;
    }

}
