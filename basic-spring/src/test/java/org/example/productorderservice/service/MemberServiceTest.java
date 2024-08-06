package org.example.productorderservice.service;

import org.example.productorderservice.domain.Member;
import org.example.productorderservice.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


class MemberServiceTest {
  private final MemoryMemberRepository memberRepository = new MemoryMemberRepository();
  MemberService memberService =  new MemberService(memberRepository);

  @AfterEach
  public void afterEach(){
    memberRepository.clearStore();
  }


  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setName("hello");
    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());
  }

  @Test
  public void 중복_회원_예외(){
    //given
    Member member1 = new Member();
    member1.setName("spring");

    Member member2 = new Member();
    member2.setName("spring");
    //when
    memberService.join(member1);

    IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
//    try{
//      memberService.join(member2);
//      fail();
//    }catch (IllegalStateException e){
//      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//    }
    //then
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

  }

  @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }
}