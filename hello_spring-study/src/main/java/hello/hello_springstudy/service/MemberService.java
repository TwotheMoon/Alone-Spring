package hello.hello_springstudy.service;

import hello.hello_springstudy.domain.Member;
import hello.hello_springstudy.repository.MemberRepository;
import hello.hello_springstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // 테스트 리포지토리와 같은 걸 쓰기위해 외부에서 가져오는 식으로 통일

    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }


    /**
    * 회원 가입
    */
    public Long join(Member member) {

        Long start = System.currentTimeMillis();
    try{
        validateDuplicateMember(member);    // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    } finally {
       Long finish = System.currentTimeMillis();
        Long timeMs = finish - start;
        System.out.println("join = " + timeMs + "ms");
        }
    }

    private void validateDuplicateMember(Member member){
        //Optional<Member> result = memberRepository.findByName(member.getName());
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {  // 메모리 리포지토리에서 멤버의 이름을 찾아와 같은지 비교 후 null 이 아니면
                throw new IllegalStateException("이미 존재하는 회원입니다.");
                        // 람다식을 이용홰 Optional을 숨기고 바로 적용
                });
    }

    /**
    *  전체 회원 조회
    */
    public List<Member> findMembers(){
       return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
