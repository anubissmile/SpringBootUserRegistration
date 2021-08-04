package com.backendtest.UserRegistration.User.enumerate;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum MemberTypeEnum {
    PLATINUM("Platinum"),
    GOLD("Gold"),
    SILVER("Silver");

    private String code;

    public static MemberTypeEnum fromCode(String code) {
        for(MemberTypeEnum member : MemberTypeEnum.values()) {
            if(member.getCode().equals(code)) {
                return member;
            }
        }
        return null;
    }

    private MemberTypeEnum(String code) {
        this.code = code;
    }

}
