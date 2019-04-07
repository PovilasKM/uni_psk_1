package lt.vu.usecases.dao;

import lt.vu.entities.Job;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class JobDAO {
    @Inject
    private EntityManager em;

    public void create(Job job) {
        em.persist(job);
    }
}
