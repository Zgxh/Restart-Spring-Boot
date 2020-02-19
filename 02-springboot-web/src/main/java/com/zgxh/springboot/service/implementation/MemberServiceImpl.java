package com.zgxh.springboot.service.implementation;

import com.zgxh.springboot.mapper.MemberInfoMapper;
import com.zgxh.springboot.model.MemberInfo;
import com.zgxh.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-19 19:01
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberInfoMapper memberInfoMapper;

    @Override
    public List<MemberInfo> getAllMembers() {
        return memberInfoMapper.getAllMembers();
    }
}
