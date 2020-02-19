package com.zgxh.springboot.mapper;

import com.zgxh.springboot.model.MemberInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberInfoMapper {

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    List<MemberInfo> getAllMembers();

}