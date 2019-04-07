package lt.vu.usecases.controllers;


import lombok.Getter;
import lt.vu.entities.Firm;
import lt.vu.entities.Freelancer;
import lt.vu.entities.Job;
import lt.vu.usecases.dao.FirmDAO;
import lt.vu.usecases.dao.FreelancerDAO;
import lt.vu.usecases.dao.JobDAO;

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

    @Getter
    private Job job = new Job();

    @Inject
    private FirmDAO firmDAO;

    @Inject
    private FreelancerDAO freelancerDAO;

    @Inject
    private JobDAO jobDAO;

    @PostConstruct
    public void init() {
        loadAllFirms();
    }

    @Transactional
    public void createFirmWithFreelancers() {
        firm.getFreelancers().add(freelancer);
        freelancer.setFirm(firm);
        freelancer.getJobs().add(job);
        freelancerDAO.create(freelancer);
        firmDAO.create(firm);
        jobDAO.create(job);
    }

    private void loadAllFirms() {
        this.firms = firmDAO.getAllFirms();
    }
}
