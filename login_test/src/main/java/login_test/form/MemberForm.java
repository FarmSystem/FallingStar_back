package login_test.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class MemberForm {

    @NotBlank(message = "이메일은 필수값입니다.")
    private String email;

    @Size(min = 4, max = 16, message = "패스워드는 4~16자까지 가능합니다.")
    private String password;

    @NotBlank(message = "이름은 필수값입니다.")
    private String name;

    @NotBlank(message = "생일은 필수값입니다.")
    private String birth;

    @NotNull(message = "성별은 필수값입니다.")
    private Boolean sex;

    @NotBlank(message = "대학은 필수값입니다.")
    private String university;

    private String oneLineIntroduction;

    @NotNull(message = "동의사항 입력은 필수입니다.")
    private Boolean termConsent;
}
