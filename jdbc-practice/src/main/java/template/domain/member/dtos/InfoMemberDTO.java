package template.domain.member.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class InfoMemberDTO {
    private String id;
    private String pw;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String indate;

    @Override
    public String toString() {
        return "InfoMemberDTO{" +
                "id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
