package com.globalco.jobboard.repository;

import com.globalco.jobboard.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}