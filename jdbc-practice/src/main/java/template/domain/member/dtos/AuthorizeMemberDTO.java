package template.domain.member.dtos;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class AuthorizeMemberDTO {
    private String id;
    private String pw;
}

