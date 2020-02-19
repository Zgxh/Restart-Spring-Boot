package com.zgxh.springboot.service;

import com.zgxh.springboot.model.MemberInfo;

import java.util.List;

/**
 * @author Yu Yang
 * @create 2020-02-19 18:59
 */
public interface MemberService {

    public List<MemberInfo> getAllMembers();
}
