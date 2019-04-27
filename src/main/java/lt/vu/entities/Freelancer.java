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
@Table(name = "freelancers")
@Getter
@Setter
@ToString(of = {"id", "name"})
public class Freelancer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String name;

    @JoinColumn(name = "firm_id", referencedColumnName = "id")
    @ManyToOne
    @JohnzonIgnore
    private Firm firm;

    @JoinTable(name = "freelancers_jobs",
        joinColumns = {@JoinColumn(name = "freelancer_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "job_id", referencedColumnName = "id")}
    )
    @ManyToMany
    private List<Job> jobs = new ArrayList<>();

    @Version
    @Column(name = "opt_lock_version")
    @JohnzonIgnore
    private Integer optLockVersion;
}
