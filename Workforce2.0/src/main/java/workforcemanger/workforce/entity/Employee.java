package workforcemanger.workforce.entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "phone")
    private String phone;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "position")
    private String position;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "children_count")
    private int childrenCount;

    @Column(name = "social_security_number")
    private String socialSecurityNumber;
    @Column(name = "password")
    private String password;
    public Employee() {}
    public Employee( int id , String userName , String email , String role , String phone , LocalDate dateOfBirth , String address , String position , LocalDate hireDate , Double salary , int childrenCount , String socialSecurityNumber , String password ) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.role = "employee";
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.childrenCount = childrenCount;
        this.socialSecurityNumber = socialSecurityNumber;
        this.password = password;
    }
    public Employee(String userName , String email , String role , String phone , LocalDate dateOfBirth , String address , String position , LocalDate hireDate , Double salary , int childrenCount , String socialSecurityNumber , String password ) {
        this.userName = userName;
        this.email = email;
        this.role = "employee";
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.childrenCount = childrenCount;
        this.socialSecurityNumber = socialSecurityNumber;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", phone='" + phone + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", childrenCount=" + childrenCount +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                '}';
    }
}
