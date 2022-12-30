package template.domain.member.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String indate;
}
