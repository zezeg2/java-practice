package template.domain.member.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InfoMemberDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String indate;

}
