package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String createFoem() {
        return "members/createMembersForm";
    }

    @PostMapping("members/new")
    public String createForm(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String showMembers(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "members/memberList";
    }

}
