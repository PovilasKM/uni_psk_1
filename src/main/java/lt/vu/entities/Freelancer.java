package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "freelancers")
@Getter
@Setter
@ToString(of = {"id"})
public class Freelancer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "firm_id", referencedColumnName = "id")
    @ManyToOne
    private Firm firm;

    @JoinTable(name = "freelancers_jobs",
        joinColumns = {@JoinColumn(name = "freelancer_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "job_id", referencedColumnName = "id")}
    )
    @ManyToMany
    private List<Job> jobs = new ArrayList<>();

}
