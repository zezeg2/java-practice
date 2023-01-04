package domain.members.exceptions;

/**
 * Created by jonghyeon on 2022/12/30,
 * Package : template.domain.member.exceptions
 */
public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException() {
        super("존재하지 않는 아이디입니다.");
    }
}
