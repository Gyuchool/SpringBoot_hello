package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")//url창에 입력, 조회할떄 주로
    public String createForm(){
        return "members/createMemberForm";//return 하면 template에서 html찾음(create~.html)
    }

    @PostMapping("/members/new")//data를 전달할떄 주로 post
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";//home화면으로 보내기
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";

    }
}
