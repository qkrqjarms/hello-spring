package hello.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member){
        // 이름 중복 검증
        validateDuplicate(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 전체 조회
     */
    public List<Member> findMembers(){

        return memberRepository.findAll();
    }

    /**
     * 단건 조회
     */
    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }

    /**
     * 회원가입 전 중복체크.
     * @param member
     */
    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

}
