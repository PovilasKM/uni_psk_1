package lt.vu.usecases.controllers;


import lombok.Getter;
import lt.vu.entities.Firm;
import lt.vu.entities.Freelancer;
import lt.vu.usecases.dao.FreelancerDAO;
import lt.vu.usecases.dao.FirmDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class EmploymentControllerJPA {
    @Getter
    private List<Firm> firms;

    @Getter
    private Firm firm = new Firm();

    @Getter
    private Freelancer freelancer = new Freelancer();

    @Inject
    private FirmDAO firmDAO;

    @Inject
    private FreelancerDAO freelancerDAO;

    @PostConstruct
    public void init() {
        loadAllUsers();
    }

    @Transactional
    public void createUserWithOrder() {
        firm.getFreelancers().add(freelancer);
        freelancer.setFirm(firm);
        freelancerDAO.create(freelancer);
        firmDAO.create(firm);
    }

    private void loadAllUsers() {
        this.firms = firmDAO.getAllFirms();
    }
}
