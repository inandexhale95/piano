package com.devlog.piano.security.controller;

import com.devlog.piano.member.domain.Member;
import com.devlog.piano.member.domain.Role;
import com.devlog.piano.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SecurityController {

    private MemberRepository memberRepository;

    @Autowired
    public SecurityController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @GetMapping("/system/login")
    public void login() {}

    @GetMapping("/system/register")
    public String register() {
        return "/system/register";
    }

    @PostMapping("/system/register")
    public String register(Member member) {
        member.setEnabled(true);
        member.setRole(Role.ROLE_MEMBER);
        memberRepository.save(member);

        return "redirect:system/login";
    }

    @GetMapping("/system/accessDenied")
    public void accessDenied() {}

    @GetMapping("/system/logout")
    public void logout() {}

    @GetMapping("admin/adminPage")
    public void admin() {}
}
