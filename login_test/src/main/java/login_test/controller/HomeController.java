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

    @GetMapping("/home") // 이게 url 주소 써놓은거라고 보면 됨 localhost:8080/home
    public String home(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return "hello, stranger";
        }

        Member loginMember = (Member)session.getAttribute("loginMember");

        return "hello, " + loginMember.getName(); // 반갑습니다 이도윤님
    }

}