package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Job;

public interface JobMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.jobs
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.jobs
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int insert(Job record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.jobs
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    Job selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.jobs
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    List<Job> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.jobs
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int updateByPrimaryKey(Job record);
}