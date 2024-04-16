package com.app.external.oauth.kakao.service;

import com.app.external.oauth.service.SocialLoginApiService;
import com.app.jwtpractice.domain.member.constant.MemberType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SocialLoginApiServiceFactory {
    private static Map<String, SocialLoginApiService> socialLoginApiServices;

    public SocialLoginApiServiceFactory(Map<String, SocialLoginApiService> socialLoginApiServices) {
        this.socialLoginApiServices = socialLoginApiServices;
    }

    public static SocialLoginApiService getSocialLoginApiService(MemberType memberType) {
        String socialLoginApiServiceBeanName = "";

        if(MemberType.KAKAO.equals(memberType)) {
            socialLoginApiServiceBeanName = "kakaoLoginApiServiceImpl"; // 적절환 소셜 구현체를 반환하기 위해서
        }

        return socialLoginApiServices.get(socialLoginApiServiceBeanName); // bean 이름으로 구현체 꺼낸다.
    }
}
