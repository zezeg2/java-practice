package ch7.board;

public class Member extends Information {
    private String email;
    private String phone;

    public Member(String id, String name, String email, String phone) {
        super(id, name);
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String print() {
        return super.print() + String.format("%s : %s", email, phone);
    }
}
