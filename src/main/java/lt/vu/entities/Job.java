package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.johnzon.mapper.JohnzonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@ToString(of = {"id", "title"})
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToMany(mappedBy = "jobs")
    @JohnzonIgnore
    private List<Freelancer> freelancers = new ArrayList<>();

    @Version
    @Column(name = "opt_lock_version")
    @JohnzonIgnore
    private Integer optLockVersion;
}
