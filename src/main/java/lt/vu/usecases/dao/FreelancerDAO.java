package lt.vu.usecases.dao;

import lt.vu.entities.Freelancer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class FreelancerDAO {
    @Inject
    private EntityManager em;

    public void create(Freelancer freelancer) {
        em.persist(freelancer);
    }
}
