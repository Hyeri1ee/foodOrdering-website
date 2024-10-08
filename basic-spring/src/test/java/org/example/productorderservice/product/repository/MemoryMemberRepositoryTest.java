package org.example.productorderservice.product.repository;

import org.example.productorderservice.domain.Member;
import org.example.productorderservice.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

  MemoryMemberRepository repository = new MemoryMemberRepository();
  @AfterEach
  public void afterEach(){
    repository.clearStore();
  }
  @Test
  public void save(){
    Member member = new Member();
    member.setEmail("spring@gmail.com");

    repository.save(member);

    Member result = repository.findById(member.getId()).get();
    assertThat(member).isEqualTo(result);
  }

  @Test
  public void findByName(){
    Member member1 =  new Member();
    member1.setEmail("스프링1@gmail.com");
    repository.save(member1);

    Member member2 =  new Member();
    member2.setEmail("스프링2@gmail.com");
    repository.save(member2);

    Member result = repository.findByEmail("스프링1@gmail.com").get();

    assertThat(result).isEqualTo(member1);

  }


  @Test
  public void findAll(){
    Member member1 =  new Member();
    member1.setEmail("스프링1@gmail.com");
    repository.save(member1);

    Member member2 =  new Member();
    member2.setEmail("스프링2@gmail.com");
    repository.save(member2);

    List<Member> result = repository.findAll();

    assertThat(result.size()).isEqualTo(2);

  }
}
