package com.app.api.login.service;

import com.app.domain.member.constant.Role;
import com.app.domain.member.entity.Member;
import com.app.domain.member.service.MemberService;
import com.app.external.oauth.service.SocialLoginApiServiceFactory;
import com.app.external.oauth.model.OAuthAttributes;
import com.app.external.oauth.service.SocialLoginApiService;
import com.app.api.login.dto.OauthLoginDto;
import com.app.domain.member.constant.MemberType;
import com.app.global.jwt.dto.JwtTokenDto;
import com.app.global.jwt.service.TokenManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OauthLoginService {

    private final MemberService memberService;
    private final TokenManager tokenManager;

    public OauthLoginDto.Response oauthLogin(String accessToken, MemberType memberType) {
        //어떤 social service 인지 memberType 으로 판단
        SocialLoginApiService socialLoginApiService = SocialLoginApiServiceFactory.getSocialLoginApiService(memberType);
        //해당하는 open api 에 token으로 user 정보 가져옴
        OAuthAttributes userInfo = socialLoginApiService.getUserInfo(accessToken);

        log.info("userInfo : {}", userInfo);
        JwtTokenDto jwtTokenDto;
        //유저 정보로 존재하는 회원인지 판단
        Member member = memberService.findMemberByEmail(userInfo.getEmail());
        if(member == null) {
            //신규 가입
            Member oauthMember = userInfo.toMemberEntity(memberType, Role.ADMIN);
            oauthMember = memberService.registerMember(oauthMember);
            //토큰 생성
            jwtTokenDto = tokenManager.createJwtTokenDto(oauthMember.getMemberId(), oauthMember.getRole());
            oauthMember.updateRefreshToken(jwtTokenDto);
        } else {
            //토큰 생성
            jwtTokenDto = tokenManager.createJwtTokenDto(member.getMemberId(), member.getRole());
            member.updateRefreshToken(jwtTokenDto);
        }

        return OauthLoginDto.Response.of(jwtTokenDto);
    }
}