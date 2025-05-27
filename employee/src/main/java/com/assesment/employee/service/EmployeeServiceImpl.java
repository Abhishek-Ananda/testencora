package com.assesment.employee.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.assesment.employee.dto.EmployeeDto;
import com.assesment.employee.entity.EmployeeEntity;
import com.assesment.employee.repo.EmployeeRepo;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmplyeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Transactional
    public EmployeeEntity addClient(EmployeeDto dto) {
      EmployeeEntity client = new EmployeeEntity();
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        return employeeRepo.save(client);
    }

    @Transactional
    public List<EmployeeEntity> getAllClients() {
        return employeeRepo.findAll();
    }

    @Transactional
    public EmployeeEntity updateClient(EmployeeDto dto) {
      EmployeeEntity client = employeeRepo.findByEmailId(dto.getEmail()).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(dto.getName());
        client.setEmail(dto.getEmail());
        client.setPhoneNumber(dto.getPhoneNumber());
        return employeeRepo.save(client);
    }
    public Page<EmployeeEntity> getEmployeesPaginated(int page) {
      int pageSize = 10; 
      return employeeRepo.findAll(PageRequest.of(page, pageSize));
  }
    
}
