package com.zerobase.festlms.admin;

import java.util.List;

import com.zerobase.festlms.admin.model.MemberParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zerobase.festlms.member.entity.Member;
import com.zerobase.festlms.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class AdminMemberController {
    private final MemberService memberService;

    @GetMapping("/admin/member/list.do")
    public String list(Model model, MemberParam memberParam) {

        List<Member> members = memberService.list(memberParam);

        model.addAttribute("list", members);

        return "admin/member/list";
    }
}
