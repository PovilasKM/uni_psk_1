package lt.vu.usecases.mybatis.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FreelancerJob {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.freelancers_jobs.freelancer_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    private Integer freelancerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.freelancers_jobs.job_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    private Integer jobId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.freelancers_jobs.freelancer_id
     *
     * @return the value of public.freelancers_jobs.freelancer_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    public Integer getFreelancerId() {
        return freelancerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.freelancers_jobs.freelancer_id
     *
     * @param freelancerId the value for public.freelancers_jobs.freelancer_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    public void setFreelancerId(Integer freelancerId) {
        this.freelancerId = freelancerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.freelancers_jobs.job_id
     *
     * @return the value of public.freelancers_jobs.job_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.freelancers_jobs.job_id
     *
     * @param jobId the value for public.freelancers_jobs.job_id
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }
}