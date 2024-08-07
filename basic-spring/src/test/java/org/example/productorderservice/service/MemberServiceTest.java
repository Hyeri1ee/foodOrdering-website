package org.example.productorderservice.service;

import jakarta.persistence.EntityManager;
import org.example.productorderservice.domain.Member;
import org.example.productorderservice.repository.JpaMemberRepository;
import org.example.productorderservice.repository.MemberRepository;
import org.example.productorderservice.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
class MemberServiceTest {

  @Autowired
  MemberService memberService;
  @Autowired
  MemberRepository memberRepository;


  @Test
  void 회원가입() {
    //given
    Member member = new Member();
    member.setEmail("hello@gmail.com");
    //when
    Long saveId = memberService.join(member);

    //then
    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getEmail()).isEqualTo(findMember.getEmail());
  }

  @Test
  public void 중복_회원_예외(){
    //given
    Member member1 = new Member();
    member1.setEmail("spring@gmail.com");

    Member member2 = new Member();
    member2.setEmail("spring@gmail.com");
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