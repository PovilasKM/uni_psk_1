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

    public Freelancer findById(Integer id) {
        return em.find(Freelancer.class, id);
    }

    public void update(Freelancer freelancer){
        em.merge(freelancer);
    }
}
