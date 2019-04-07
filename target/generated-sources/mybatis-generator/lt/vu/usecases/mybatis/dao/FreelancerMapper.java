package lt.vu.usecases.mybatis.dao;

import java.util.List;
import lt.vu.usecases.mybatis.model.Freelancer;

public interface FreelancerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.freelancers
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.freelancers
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int insert(Freelancer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.freelancers
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    Freelancer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.freelancers
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    List<Freelancer> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table public.freelancers
     *
     * @mbg.generated Sun Apr 07 16:25:19 EEST 2019
     */
    int updateByPrimaryKey(Freelancer record);
}