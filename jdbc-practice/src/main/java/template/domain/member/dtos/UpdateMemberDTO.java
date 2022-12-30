package template.domain.member.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateMemberDTO {
    private String id;
    private String pw;
    private String email;
    private String phone;
    private String address;
}
