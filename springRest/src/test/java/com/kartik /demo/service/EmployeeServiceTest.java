package com.kartik.demo.service;
import com.kartik.demo.entity.Employee;
import com.kartik.demo.repository.EmployeeRepository;
import com.kartik.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void getAllEmployees() {
        List<Employee> mockEmployees = Arrays.asList(
                new Employee("John Doe", "IT", 30),
                new Employee("Jane Smith", "HR", 28)
        );

        when(employeeRepository.findAll()).thenReturn(mockEmployees);

        List<Employee> result = employeeService.getAllEmployees();

        assertEquals(2, result.size());
        assertEquals("John Doe", result.get(0).getName());
        assertEquals("Jane Smith", result.get(1).getName());

        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    void createEmployee() {
        Employee newEmployee = new Employee(null, "New Employee", 25);
        Employee savedEmployee = new Employee("New Employee", "Sales", 25);

        when(employeeRepository.save(newEmployee)).thenReturn(savedEmployee);

        Employee result = employeeService.createEmployee(newEmployee);

        assertEquals(1, result.getId());
        assertEquals("New Employee", result.getName());
        assertEquals("Sales", result.getDepartment());
        assertEquals(25, result.getAge());

        verify(employeeRepository, times(1)).save(newEmployee);
    }

    @Test
    void getEmployeeById() {
        int employeeId = 1;
        Employee mockEmployee = new Employee("John Doe", "IT", 30);

        when(employeeRepository.findById(employeeId)).thenReturn(Optional.of(mockEmployee));

        Optional<Employee> result = employeeService.getEmployeeById(employeeId);

        assertTrue(result.isPresent());
        assertEquals("John Doe", result.get().getName());
        assertEquals("IT", result.get().getDepartment());
        assertEquals(30, result.get().getAge());

        verify(employeeRepository, times(1)).findById(employeeId);
    }

    @Test
    void deleteEmployeeById() {
        int employeeId = 1;

        employeeService.deleteEmployeeById(employeeId);

        verify(employeeRepository, times(1)).deleteById(employeeId);
    }

    @Test
    void updateEmployeeById() {
        int employeeId = 1;
        Employee updatedEmployee = new Employee("Updated Employee", "Marketing", 35);

        when(employeeRepository.save(updatedEmployee)).thenReturn(updatedEmployee);

        Employee result = employeeService.updateEmployeeById(updatedEmployee, employeeId);

        assertEquals("Updated Employee", result.getName());
        assertEquals("Marketing", result.getDepartment());
        assertEquals(35, result.getAge());

        verify(employeeRepository, times(1)).save(updatedEmployee);
    }
}
