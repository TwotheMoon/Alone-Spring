package hello.hello_springstudy.repository;

import hello.hello_springstudy.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MeoryMemeberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 아래 모든 테스트는 순차적으로 작동X 데이터가 섞여 오류 발생대비 각 테스트 끝남과 동시에 메모리 초기화
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("moon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("moon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("moon2");
        repository.save(member2);

        Member result = repository.findByName("moon1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("moon1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("moon2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
