package template.domain.member.exceptions;

/**
 * Created by jonghyeon on 2022/12/30,
 * Package : template.domain.member.exceptions
 */
public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
