package com.zerobase.festlms.member.service;

import com.zerobase.festlms.admin.model.MemberParam;
import com.zerobase.festlms.member.entity.Member;
import com.zerobase.festlms.member.model.MemberInput;
import com.zerobase.festlms.member.model.ResetPasswordInput;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService extends UserDetailsService {

    boolean register(MemberInput memberInput);

    boolean emailAuth(String uuid);

    boolean sendResetPassword(ResetPasswordInput parameter);

    boolean resetPassword(String uuid, String password);

    boolean checkResetPassword(String uuid);

    List<Member> list(MemberParam memberParam);
}

