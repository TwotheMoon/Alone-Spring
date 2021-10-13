package hello.hello_springstudy.service;

import hello.hello_springstudy.domain.Member;
import hello.hello_springstudy.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() { // 우선 실행
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach // 아래 모든 테스트는 순차적으로 작동X 데이터가 섞여 오류 발생대비 각 테스트 끝남과 동시에 메모리 초기화
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test

    void 회원가입() {
        //given 실무자 패턴
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // 중복값에 의해 예외가 발생해야 정상
        
        /*
        try {
            memberService.join(member2);
            fail();
        }  catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */

        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}