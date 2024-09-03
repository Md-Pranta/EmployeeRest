package employeePack.service;

import employeePack.exception.UserNotFoundException;
import employeePack.exception.UserNotFoundException;
import employeePack.model.Employee;
import employeePack.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo obj){
        employeeRepo = obj;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long id){
        return Optional.ofNullable(employeeRepo.findById(id).orElseThrow(() -> new UserNotFoundException("User id" + id + "was not found")));
    }

    public  void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
