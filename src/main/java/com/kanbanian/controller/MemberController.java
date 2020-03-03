package com.kanbanian.controller;

import com.kanbanian.entity.Member;
import com.kanbanian.repository.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    final MemberRepo memberRepo;

    @Autowired
    public MemberController(MemberRepo memberRepo) {
        this.memberRepo = memberRepo;
    }

    @GetMapping
    Iterable getAllMembers() {
        return memberRepo.findAll();
    }

    @GetMapping("{id}")
    Member getMemberById(@PathVariable("id") Member member) {
        return member;
    }

    @PostMapping
    Member createMember(@RequestBody Member member) {
        return memberRepo.save(member);
    }

    @PutMapping("{id}")
    Member updateMember(
            @PathVariable("id") Member oldMember,
            @RequestBody Member newMember) {
        if (oldMember.getName() != null) {
            oldMember.setName(newMember.getName());
        }

        if (oldMember.getSurname() != null) {
            oldMember.setSurname(newMember.getSurname());
        }

        if (oldMember.getPassword() != null) {
            oldMember.setPassword(newMember.getPassword());
        }

        if (oldMember.getPricture() != null) {
            oldMember.setPricture(newMember.getPricture());
        }
        return memberRepo.save(oldMember);
    }

    @DeleteMapping("{id}")
    void deleteMember(@PathVariable("id") Member member) { memberRepo.delete(member); }
}
