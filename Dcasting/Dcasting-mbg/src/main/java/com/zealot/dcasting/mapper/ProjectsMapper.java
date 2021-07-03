package com.zealot.dcasting.mapper;

import com.zealot.dcasting.model.Projects;
import com.zealot.dcasting.model.ProjectsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectsMapper {
    long countByExample(ProjectsExample example);

    int deleteByExample(ProjectsExample example);

    int deleteByPrimaryKey(String projectId);

    int insert(Projects record);

    int insertSelective(Projects record);

    List<Projects> selectByExample(ProjectsExample example);

    Projects selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByExample(@Param("record") Projects record, @Param("example") ProjectsExample example);

    int updateByPrimaryKeySelective(Projects record);

    int updateByPrimaryKey(Projects record);
}