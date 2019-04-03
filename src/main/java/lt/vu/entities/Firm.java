package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "firms")
@NamedQueries({
        @NamedQuery(name = "Firm.findAll", query = "SELECT u FROM Firm u")
})
@Getter
@Setter
@ToString(of = {"id", "name"})
public class Firm implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "firm")
    private List<Freelancer> freelancers = new ArrayList<>();

}
