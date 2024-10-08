package org.example.productorderservice.repository;

import jakarta.persistence.EntityManager;
import org.example.productorderservice.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class JpaMemberRepository implements MemberRepository{

  private final EntityManager em;

  public JpaMemberRepository(EntityManager em) {
    this.em = em;
  }

  @Override
  public Member save(Member member) {
    em.persist(member);
    return member;
  }

  @Override
  public Optional<Member> findById(Long id) {
    Member member = em.find(Member.class, id);
    return Optional.ofNullable(member);
  }

  @Override
  public Optional<Member> findByEmail(String email) {
    List<Member> result = em.createQuery("select m from Member m where m.email = :email", Member.class)
            .setParameter("email" , email)
            .getResultList();

    return result.stream().findAny();
  }

  @Override
  public List<Member> findAll() {
    List<Member> result = em.createQuery("SELECT m from Member m" , Member.class)
            .getResultList();

    return result;
  }

  public void clearStore(){
    em.clear();
  }
}
