package com.kanbanian.repository;

import com.kanbanian.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Id;

public interface LabelRepo extends JpaRepository<Label, Id> {
}
