package com.app.domain.member.service;

import com.app.domain.member.entity.Member;
import com.app.domain.member.repository.MemberRepository;
import com.app.global.error.ErrorCode;
import com.app.global.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member registerMember(Member member) {
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member) {
        Member member1 = Optional.ofNullable(memberRepository.findByEmail(member.getEmail())).orElseThrow(() -> new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER));
    }
}
