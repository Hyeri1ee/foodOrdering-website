package org.example.productorderservice.repository;

import org.example.productorderservice.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

  Member save(Member member);
  Optional<Member> findById(Long id);
  Optional<Member> findByEmail(String email);
  List<Member> findAll();
}
