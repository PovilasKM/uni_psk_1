package lt.vu.usecases.rest;

import lt.vu.entities.Firm;
import lt.vu.usecases.interceptors.MyInterceptor;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@MyInterceptor
@Alternative
@ApplicationScoped
@Path("/firm")
@Produces(MediaType.APPLICATION_JSON)
public class FirmRestService {

    @Inject
    private EntityManager em;

    @GET
    @Path("/{firmId}")
    public Firm find(@PathParam("firmId") Integer userId) {
        return em.find(Firm.class, userId);
    }

    @GET
    @Path("")
    public List<Firm> find() {
        return em.createNamedQuery("Firm.findAll", Firm.class).getResultList();
    }

    @Path("/")
    @POST
    @Transactional
    public Firm create(@QueryParam("name") String name) {
        Firm firm = new Firm();
        firm.setName(name);
        em.persist(firm);
        return firm;
    }

    @Path("/{firmId}")
    @PUT
    @Transactional
    public Response update(@PathParam("firmId") Integer firmId,
                           @QueryParam("name") String name) {
        Firm firm = em.find(Firm.class, firmId);
        if (firm == null) {
            throw new IllegalArgumentException("firm id " + firmId + " not found");
        }
        firm.setName(name);
        em.merge(firm);
        em.flush();
        return Response.ok(firm).build();
    }
}
