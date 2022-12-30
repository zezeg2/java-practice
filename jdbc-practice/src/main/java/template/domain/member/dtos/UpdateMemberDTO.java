package template.domain.member.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateMemberDTO {
    private String id;
    private String pw;
    private String email;
    private String phone;
    private String address;
}
