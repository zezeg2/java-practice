package template.domain.member.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthorizeMemberDTO {
    private String id;
    private String pw;
}
