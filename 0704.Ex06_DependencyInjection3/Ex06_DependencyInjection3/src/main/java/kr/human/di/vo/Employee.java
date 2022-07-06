package kr.human.di.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    // Class member members
    private String name;
    private String employeeID;
    private String department;
    private Address address;
}
