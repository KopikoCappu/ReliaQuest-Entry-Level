package com.challenge.api.service;

import com.challenge.api.exception.EmployeeNotFoundException;
import com.challenge.api.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<UUID, Employee> employeeStore = new ConcurrentHashMap<>();

    public EmployeeServiceImpl() {
        seedMockEmployees();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeStore.values());
    }

    @Override
    public Employee getEmployeeByUuid(UUID uuid) {
        Employee employee = employeeStore.get(uuid);

        if (employee == null) {
            throw new EmployeeNotFoundException(uuid);
        }

        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getUuid() == null) {
            employee.setUuid(UUID.randomUUID());
        }

        employeeStore.put(employee.getUuid(), employee);

        return employee;
    }

    private void seedMockEmployees() {
        Employee emp1 =
                new Employee("John", "Doe", "john.doe@company.com", "Engineering", 95000.0, "Senior Software Engineer");
        emp1.setUuid(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"));

        Employee emp2 = new Employee("Jane", "Smith", "jane.smith@company.com", "Product", 105000.0, "Product Manager");
        emp2.setUuid(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));

        Employee emp3 =
                new Employee("Bob", "Johnson", "bob.johnson@company.com", "Security", 110000.0, "Security Analyst");
        emp3.setUuid(UUID.fromString("550e8400-e29b-41d4-a716-446655440002"));

        employeeStore.put(emp1.getUuid(), emp1);
        employeeStore.put(emp2.getUuid(), emp2);
        employeeStore.put(emp3.getUuid(), emp3);
    }
}
