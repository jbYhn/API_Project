package api.project.Api_Project;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
//import java.util.Date;

@Entity
@Table(name = "Sondage")
@EntityListeners(AuditingEntityListener.class)
public class Sondage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "lieu", nullable = false)
    private String lieu;

    @Column(name = "nbVote", nullable = false)
    private int nbVote;

    @Column(name = "userId", nullable = false)
    private int userId;

    @Column(name = "date", nullable = false)
    private Date date;

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLieu() { return lieu; }

    public void setLieu(String lieu) { this.lieu = lieu; }

    public int getNbVote() { return nbVote; }

    public void setNbVote(int nbVote) { this.nbVote = nbVote; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }


}
