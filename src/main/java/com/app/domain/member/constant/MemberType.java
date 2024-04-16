package com.app.domain.member.constant;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MemberType {
    KAKAO;

    public static MemberType from(String type) {
        return MemberType.valueOf(type.toUpperCase());
    }

    public static boolean isMemberType(String type) {
        List<MemberType> memberTypes = Arrays.stream(MemberType.values()) // 병렬 처리
                .collect(Collectors.filtering(memberType -> memberType.name().equals(type), Collectors.toList()));

        return !memberTypes.isEmpty();
    }
}
