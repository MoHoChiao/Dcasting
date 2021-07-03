package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.ProjectDetails;
import com.zealot.dcasting.model.ProjectDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectDetailsMapper {
    long countByExample(ProjectDetailsExample example);

    int deleteByExample(ProjectDetailsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ProjectDetails record);

    int insertSelective(ProjectDetails record);

    List<ProjectDetails> selectByExample(ProjectDetailsExample example);

    ProjectDetails selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ProjectDetails record, @Param("example") ProjectDetailsExample example);

    int updateByExample(@Param("record") ProjectDetails record, @Param("example") ProjectDetailsExample example);

    int updateByPrimaryKeySelective(ProjectDetails record);

    int updateByPrimaryKey(ProjectDetails record);
}