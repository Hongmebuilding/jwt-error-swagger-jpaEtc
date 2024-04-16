package com.app.external.oauth.model;

import com.app.jwtpractice.domain.member.constant.MemberType;
import com.app.jwtpractice.domain.member.constant.Role;
import com.app.jwtpractice.domain.member.entity.Member;
import lombok.Builder;
import lombok.Getter;

@Getter @Builder
public class OauthAttributes { // 다른 소셜 로그인들의 정보를 하나로 통일(회원가입)
    private String name;
    private String email;
    private String profile;
    private MemberType memberType;

    public Member toMemberEntity(MemberType memberType, Role role) { //member의 password x
        return Member.builder()
                .memberName(name)
                .email(email)
                .profile(profile)
                .memberType(memberType)
                .role(role)
                .build();
    }
}
