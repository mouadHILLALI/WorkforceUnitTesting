package workforcemanger.workforce.dto;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {
    private int id;
    private String userName;
    private String email;
    private String address;
    private String position;
    private LocalDate hireDate;
    private Double salary;
    private int childrenCount;
    private String socialSecurityNumber;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private String password;
    public EmployeeDTO() {}

    public EmployeeDTO(int id, String userName, String email, String address, String position,
                       LocalDate hireDate, Double salary, int childrenCount, String socialSecurityNumber, String phoneNumber, LocalDate dateOfBirth , String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.childrenCount = childrenCount;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
        this.password = password;
    }
    public EmployeeDTO( String userName, String email, String address, String position,
                       LocalDate hireDate, Double salary, int childrenCount, String socialSecurityNumber, String phoneNumber , LocalDate dateOfBirth , String password ) {
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.position = position;
        this.hireDate = hireDate;
        this.salary = salary;
        this.childrenCount = childrenCount;
        this.socialSecurityNumber = socialSecurityNumber;
        this.phoneNumber = phoneNumber;
        this.dateOfBirth = dateOfBirth;
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

    public String getAddress() {
        return address;
    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
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
        return "EmployeeDTO{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", position='" + position + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", childrenCount=" + childrenCount +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                '}';
    }
}
