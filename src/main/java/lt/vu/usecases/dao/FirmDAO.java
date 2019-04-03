package lt.vu.usecases.dao;

import lt.vu.entities.Firm;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FirmDAO {
    @Inject
    private EntityManager em;

    public List<Firm> getAllFirms() {
        return em.createNamedQuery("Firm.findAll", Firm.class).getResultList();
    }

    public void create(Firm firm) {
        em.persist(firm);
    }
}
