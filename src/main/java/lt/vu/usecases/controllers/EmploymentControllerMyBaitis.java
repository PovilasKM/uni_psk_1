package lt.vu.usecases.controllers;

import lombok.Getter;
import lt.vu.usecases.mybatis.dao.FirmMapper;
import lt.vu.usecases.mybatis.dao.FreelancerJobMapper;
import lt.vu.usecases.mybatis.dao.FreelancerMapper;
import lt.vu.usecases.mybatis.dao.JobMapper;
import lt.vu.usecases.mybatis.model.Firm;
import lt.vu.usecases.mybatis.model.Freelancer;
import lt.vu.usecases.mybatis.model.FreelancerJob;
import lt.vu.usecases.mybatis.model.Job;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class EmploymentControllerMyBaitis {
    @Getter
    private List<Firm> firms;

    @Getter
    private Firm firm = new Firm();

    @Getter
    private Freelancer freelancer = new Freelancer();

    @Getter
    private Job job = new Job();

    @Getter
    private FreelancerJob freelancerJob = new FreelancerJob();

    @Inject
    private FirmMapper firmMapper;

    @Inject
    private FreelancerMapper freelancerMapper;

    @Inject
    private JobMapper jobMapper;

    @Inject
    private FreelancerJobMapper freelancerJobMapper;

    @PostConstruct
    public void init() {
        loadAllFirms();
    }

    @Transactional
    public void createFirmWithFreelancers() {
        firmMapper.insert(firm);
        freelancer.setFirmId(firm.getId());
        freelancerMapper.insert(freelancer);
        jobMapper.insert(job);
        freelancerJob.setJobId(job.getId());
        freelancerJob.setFreelancerId(freelancer.getId());
        freelancerJobMapper.insert(freelancerJob);
    }

    private void loadAllFirms() {
        firms = firmMapper.selectAll();
    }
}
