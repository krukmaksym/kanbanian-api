package com.kanbanian.repository;

import com.kanbanian.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface MemberRepo extends JpaRepository<Member, Id> {
}
