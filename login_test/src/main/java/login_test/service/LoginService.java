package login_test.service;

import login_test.domain.Member;
import login_test.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String email, String password) {
        return memberRepository.findByEmail(email)
                .stream().filter(member -> member.getPassword().equals(password)).findAny().orElse(null);
    }

}
