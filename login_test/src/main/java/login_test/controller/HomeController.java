package login_test.controller;

import login_test.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RestController
public class HomeController {

    @GetMapping("/home")
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "안녕하세요, 손님";
        }

        Member loginMember = (Member)session.getAttribute("loginMember");

        return "안녕하세요, " + loginMember.getName() + "님";
    }

}