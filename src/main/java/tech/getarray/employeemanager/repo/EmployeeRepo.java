package tech.getarray.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.getarray.employeemanager.model.Employee;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeById(Long id);

    List<Employee> findEmployeeByNameContaining(String name);
}
