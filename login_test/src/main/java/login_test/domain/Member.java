package login_test.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long memberId;
/*
    private Long kakaoId;*/

    private String email;

    private String password;

    private String name;

    private String birth;

    //남성 : true, 여성 : false
    private Boolean sex;

    private String university;

    @Column(name = "one_line_introduction")
    private String oneLineIntroduction;

    @Column(name = "term_consent")
    private Boolean termConsent;
}
