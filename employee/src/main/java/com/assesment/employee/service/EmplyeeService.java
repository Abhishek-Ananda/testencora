package com.assesment.employee.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.assesment.employee.dto.EmployeeDto;
import com.assesment.employee.entity.EmployeeEntity;

@Service
public interface EmplyeeService {
  EmployeeEntity updateClient(EmployeeDto dto) ;
  public List<EmployeeEntity> getAllClients();
  public EmployeeEntity addClient(EmployeeDto dto);
  Page<EmployeeEntity> getEmployeesPaginated(int page);
}
