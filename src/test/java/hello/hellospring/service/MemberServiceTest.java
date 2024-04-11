package hello.hellospring.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    // DI 
    private MemberService memberService;
    private MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }

    
    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("박범근");

        // when
        Long saveId = memberService.join(member);

        // then
        Member result = memberService.findOne(saveId).get();
        Assertions.assertThat(result.getName()).isEqualTo(member.getName());

    }

    @Test
    void 중복가입예외처리() {
        // given
        Member member1 = new Member();
        member1.setName("박범근");
        Member member2 = new Member();
        member2.setName("박범근");

        // when
        memberService.join(member1);

        // then
        org.junit.jupiter.api.Assertions.assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        // Assertions.assertThatThrownBy(IllegalStateException.class,() -> memberService.join(member2));

    }

    @Test
    void 멤버전체조회() {

    }

    @Test
    void 멤버하나조회() {

    }
}
