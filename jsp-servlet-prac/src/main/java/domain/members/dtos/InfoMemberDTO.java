package domain.members.dtos;

public record InfoMemberDTO(String id, String name, String email, String phone, String address, String indate) {
    @Override
    public String toString() {
        return "InfoMemberDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}
