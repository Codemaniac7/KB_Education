package org.scoula.member.exception;

public class PasswordMissMatchException extends RuntimeException{
    public PasswordMissMatchException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}