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
    private String name;
    private String password;
    private String phonenumber;
    private String birth;

}
