package org.example.productorderservice;

import jakarta.persistence.EntityManager;
import org.example.productorderservice.repository.JpaMemberRepository;
import org.example.productorderservice.repository.MemberRepository;
import org.example.productorderservice.repository.MemoryMemberRepository;
import org.example.productorderservice.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
//  private EntityManager em;
//
//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }
  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository);
  }

//  @Bean
//  public MemberRepository memberRepository(){
//    return new JpaMemberRepository(em);
//  }
}
