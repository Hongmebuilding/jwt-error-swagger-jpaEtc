package com.app.jwtpractice.web.kakaotoken.dto;

import lombok.*;


public class KakaoTokenDto {
    @Builder @Getter @AllArgsConstructor @NoArgsConstructor
    public static class Request {
        private String grant_type;
        private String client_id;
        private String redirect_url;
        private String code;
        private String client_secret;
    }

    @Builder @Getter @ToString @AllArgsConstructor @NoArgsConstructor
    public static class Response {
        private String token_type;
        private String access_token;
        private String expires_in;
        private String refresh_token;
        private String refresh_token_expires_in;
        private String scope;
    }
}
