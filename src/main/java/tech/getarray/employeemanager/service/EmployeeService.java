package tech.getarray.employeemanager.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarray.employeemanager.exception.UserNotFoundException;
import tech.getarray.employeemanager.model.Employee;
import tech.getarray.employeemanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee AddEmployee(Employee employee) {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        LOGGER.info("Created user with code: {}", employee.getEmployeeCode());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID " + id + " was not found"));
    }
}
