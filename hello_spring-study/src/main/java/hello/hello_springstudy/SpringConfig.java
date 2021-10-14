package hello.hello_springstudy;

import hello.hello_springstudy.repository.JpaMemberRepository;
import hello.hello_springstudy.repository.MemberRepository;
import hello.hello_springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    private EntityManager em;
//
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }


//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
       // return new MemoryMemberRepository(); h2 연동
       // return new JdbcMemberRepository(dataSource); 순수 JDBC 연동
       // return new JdbcTemplateMemberRepository(dataSource); 스프링 JDBC 템플릿
        //return new JpaMemberRepository(em);

    }

