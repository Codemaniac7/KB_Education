package org.scoula.controller;

import lombok.extern.log4j.Log4j;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Log4j
@RequestMapping("/security")
@Controller
public class SecurityController {
    @GetMapping("/all") // 모두 접근 가능
    public void doAll() {
        log.info("do all can access everybody");
    }

    @GetMapping("/member") // MEMBER 또는 ADMIN 권한 필요
    public void doMember(Principal principal) {
        log.info("username = " + principal.getName());
    }

    @GetMapping("/admin") // ADMIN 권한 필요
    public void doAdmin(@AuthenticationPrincipal CustomUser customUser) {
        MemberVO memberVO = customUser.getMember();

        String mbti = memberVO.getMbti();
        String username = memberVO.getUsername();
        log.info("username = " + username);
        log.info("mbti = " + mbti);
    }

    @GetMapping("/login")
    public void login(Principal principal) {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}
