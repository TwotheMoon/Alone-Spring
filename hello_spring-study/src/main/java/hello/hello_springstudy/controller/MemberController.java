package hello.hello_springstudy.controller;

import hello.hello_springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();
    // 다른 컨트롤러에서 하나의 컨트롤러의 공유를 위해 객체 생성X

    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에 바로 올려 여러 군대서 사용 하기 위해 의존성 주입 (DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
