package login_test.controller;

import login_test.domain.Member;
import login_test.form.MemberForm;
import login_test.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String createForm() {
        return "회원가입 페이지 입니다.";
    }

    @PostMapping("/signup")
    public String create(@RequestBody @Valid MemberForm form) {

        Member member = new Member();
        member.setEmail(form.getEmail());
        member.setPassword(form.getPassword());
        member.setName(form.getName());
        member.setBirth(form.getBirth());
        member.setSex(form.getSex());
        member.setUniversity(form.getUniversity());
        member.setOneLineIntroduction(form.getOneLineIntroduction());
        member.setTermConsent(form.getTermConsent());

        Long joinedId = memberService.join(member);

        if (joinedId == null) {
            return "signup fail";
        }

        return "signup success";
    }
}
