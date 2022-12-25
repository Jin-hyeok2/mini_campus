package com.zerobase.festlms.member.controller;

import com.zerobase.festlms.member.model.MemberInput;
import com.zerobase.festlms.member.model.ResetPasswordInput;
import com.zerobase.festlms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @RequestMapping("/member/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/member/find/password")
    public String findPassword() {
        return "member/find_password";
    }

    @PostMapping("/member/find/password")
    public String findPasswordSubmit(
            Model model,
            ResetPasswordInput parameter) {
        boolean result = false;
        try {
            result = memberService.sendResetPassword(parameter);
        } catch (Exception e) {

        }

        model.addAttribute("result", result);

        return "member/find_password_result";
    }

    @GetMapping("/member/reset/password")
    public String resetPassword(Model model, HttpServletRequest request) {
        String uuid = request.getParameter("id");
        model.addAttribute("uuid", uuid);

        boolean result = memberService.checkResetPassword(uuid);

        model.addAttribute("result", result);
        return "member/reset_password";
    }

    @PostMapping("/member/reset/password")
    public String resetPasswordSubmit(Model model, ResetPasswordInput parameter) {
        boolean result = false;
        try {
            result = memberService.resetPassword(parameter.getId(), parameter.getPassword());
        } catch (Exception e) {

        }

        model.addAttribute("result", result);

        return "member/reset_password_result";
    }

    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }
    @PostMapping("/member/register")
    public String registerSubmit(Model model, HttpServletRequest req, HttpServletResponse res, MemberInput memberInput) {
        boolean result = memberService.register(memberInput);
        model.addAttribute("result", result);

        return  "member/register-complete";
    }

    @GetMapping("/member/email-auth")
    public String emailAuth(Model model, @RequestParam("id") String uuid) {

        System.out.println("uuid = " + uuid);
        boolean result = memberService.emailAuth(uuid);
        model.addAttribute("result", result);

        return "member/email_auth";
    }

    @GetMapping("/member/info")
    public String memberInfo() {
        return "member/info";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {
        return "error/denied";
    }
}
