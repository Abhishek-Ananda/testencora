package com.assesment.employee.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.assesment.employee.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
  
  Optional<EmployeeEntity> findByEmailId(String emailId);
  }
