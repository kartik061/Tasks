package com.kartik.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kartik.demo.entity.Employee;
import com.kartik.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private final ObjectMapper objectMapper = new ObjectMapper();

//    @Test
//    void getAllEmployees() throws Exception {
//        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(
//                new Employee("John Doe", "IT", 30),
//                new Employee("Jane Smith", "HR", 28)
//        ));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getAllEmployees"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("[{"id":1,"name":"John Doe","department":"IT","age":30},{"id":2,"name":"Jane Smith","department":"HR","age":28}]"));
//
//        verify(employeeService, times(1)).getAllEmployees();
//    }

    @Test
    void createEmployee() throws Exception {
        Employee newEmployee = new Employee(null, "New Employee", 25);
        Employee savedEmployee = new Employee("New Employee", "Sales", 25);

        when(employeeService.createEmployee(newEmployee)).thenReturn(savedEmployee);

        mockMvc.perform(MockMvcRequestBuilders.post("/employee/createEmployee")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newEmployee)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"New Employee\",\"department\":\"Sales\",\"age\":25}"));

        verify(employeeService, times(1)).createEmployee(newEmployee);
    }

    @Test
    void getById() throws Exception {
        int employeeId = 1;
        Employee employee = new Employee("John Doe", "IT", 30);

        when(employeeService.getEmployeeById(employeeId)).thenReturn(Optional.of(employee));

        mockMvc.perform(MockMvcRequestBuilders.get("/employee/getEmployeeById/{id}", employeeId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"John Doe\",\"department\":\"IT\",\"age\":30}"));

        verify(employeeService, times(1)).getEmployeeById(employeeId);
    }

    @Test
    void deleteEmployeeById() throws Exception {
        int employeeId = 1;

        mockMvc.perform(MockMvcRequestBuilders.delete("/employee/deleteEmployeeById/{id}", employeeId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(employeeService, times(1)).deleteEmployeeById(employeeId);
    }

    @Test
    void updateEmployeeById() throws Exception {
        int employeeId = 1;
        Employee updatedEmployee = new Employee("Updated Employee", "Marketing", 35);

        when(employeeService.updateEmployeeById(updatedEmployee, employeeId)).thenReturn(updatedEmployee);

        mockMvc.perform(MockMvcRequestBuilders.put("/employee/updateEmployeeById/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"id\":1,\"name\":\"Updated Employee\",\"department\":\"Marketing\",\"age\":35}"));

        verify(employeeService, times(1)).updateEmployeeById(updatedEmployee, employeeId);
    }
}
