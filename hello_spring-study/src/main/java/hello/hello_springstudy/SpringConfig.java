package hello.hello_springstudy;

import hello.hello_springstudy.repository.MemberRepository;
import hello.hello_springstudy.repository.MemoryMemberRepository;
import hello.hello_springstudy.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
