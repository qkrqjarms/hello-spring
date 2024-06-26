package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;


public interface MemberRepository {
    Member save(Member member);
    
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);

    List<Member> findAll();

}
