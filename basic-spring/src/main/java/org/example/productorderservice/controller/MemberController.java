package org.example.productorderservice.controller;

import org.example.productorderservice.domain.Member;
import org.example.productorderservice.dto.MemberForm;
import org.example.productorderservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class MemberController {
  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/members/new")
  public String createForm(){
    return "members/createMemberForm";
  }

  @PostMapping("members/new")
  @ResponseStatus(HttpStatus.FOUND)
  public String create(MemberForm form){
    Member member = new Member();
    member.setEmail(form.getEmail());
    member.setPassword(form.getPassword());

    memberService.join(member);

    return "redirect:/";
  }

  @GetMapping("/members")
  public String list(Model model){
    List<Member> members = memberService.findMembers();
    model.addAttribute("members" , members);

    return "members/memberList";
  }
}
