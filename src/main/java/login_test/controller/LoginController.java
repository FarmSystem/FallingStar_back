package login_test.controller;

import login_test.domain.Member;
import login_test.form.LoginForm;
import login_test.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public String loginForm() {
        return "로그인 페이지 입니다.";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginForm form, HttpServletRequest request) {

        log.info("login process activate");

        Member loginMember = loginService.login(form.getEmail(), form.getPassword());

        //로그인 실패 처리
        if (loginMember == null) {
            log.info("login process fail");
            return "login fail";
        }

        log.info("login process success");
        //로그인 성공 처리
        //세션이 있으면 있는 세션 반환, 없으면 신규 세션을 생성
        HttpSession session = request.getSession();
        //세션에 로그인 회원 정보 보관
        session.setAttribute("loginMember", loginMember);
        //세션 관리자를 통해 세션을 생성하고, 회원 데이터 보관
        return "login success";
    }

    //SecureConfig 없이도 다음과 같이 로그아웃 기능
    /*@PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "logout success";
    }*/
}
