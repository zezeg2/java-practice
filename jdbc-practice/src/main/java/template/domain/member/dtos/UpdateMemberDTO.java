package template.domain.member.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMemberDTO {
    private String id;
    private String pw;
    private String email;
    private String phone;
    private String address;
}
