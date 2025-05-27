package com.assesment.employee.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.assesment.employee.dto.EmployeeDto;
import com.assesment.employee.entity.EmployeeEntity;
import com.assesment.employee.service.EmplyeeService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(value = "/onesearch")
public class EmployeeController {

 @Autowired
 EmplyeeService emplyeeService;


    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);


    @PostMapping("/create_user")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDto request) throws Exception {
     try {
       
       EmployeeEntity addEmployee = emplyeeService.addClient(request);
       return new ResponseEntity<>("Success",HttpStatus.OK);
     }catch(Exception e) {
       return new ResponseEntity<>("UnSuccessful",HttpStatus.INTERNAL_SERVER_ERROR);
     }
  }

    @PostMapping(value = "/update_user")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success"), @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<String> updateId(@RequestBody EmployeeDto request) throws Exception{
      try {
        
        EmployeeEntity updateEmployee = emplyeeService.updateClient(request);
        return new ResponseEntity<>("Success",HttpStatus.OK);
      }catch(Exception e) {
        return new ResponseEntity<>("UnSuccessful",HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }
    
    @GetMapping("/paginated")
    public ResponseEntity<Page<EmployeeEntity>> getPaginatedEmployees(@RequestParam(defaultValue = "0") int page) {
        Page<EmployeeEntity> employees = emplyeeService.getEmployeesPaginated(page);
        return ResponseEntity.ok(employees);
    }

}
