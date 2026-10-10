
package com.nexora.jobservice.repository;

import com.nexora.jobservice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}