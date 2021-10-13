package hello.hello_springstudy.controller;

import hello.hello_springstudy.domain.Member;
import hello.hello_springstudy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    // private final MemberService memberService = new MemberService();
    // 다른 컨트롤러에서 하나의 컨트롤러의 공유를 위해 객체 생성X
    private final MemberService memberService;

    @Autowired // 스프링 컨테이너에 바로 올려 여러 군대서 사용 하기 위해 의존성 주입 (DI)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //링크 이동시
    public String createForm() {
        return "members/createMemberForm";  // 폼 html을 뿌려주고
    }

    @PostMapping("/members/new") // 폼 html에서 받은 name값을 멤버 서비스 조인 메서드를 이용해 레포지토리 저장
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members") // Model : request.setArrtibute 와 비슷 한 역할
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
