package workforcemanger.workforce.entity;

import workforcemanger.workforce.enums.StatusEnum;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leaveRequestId;
    @Column(name="startDate")
    private LocalDate startDate;
    @Column(name="endDate")
    private LocalDate endDate;
    @Column(name="reason")
    private String leaveReason;
    @Column(name="status")
    private String status;
    @Column(name="docs")
    private String supportingDocs;
    @Column(name="balance")
    private int leaveBalance;
    @Column(name="type")
    private String type ;
    @Column(name = "employee_id")
    private int employeeId;
    public LeaveRequest(){}
    public LeaveRequest(int leaveRequestId, LocalDate startDate , LocalDate endDate , String leaveReason, String status, String supportingDocs, int leaveBalance, String type, int employeeId) {
        this.leaveRequestId = leaveRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveReason = leaveReason;
        this.status = status;
        this.supportingDocs = supportingDocs;
        this.leaveBalance = leaveBalance;
        this.type = type;
        this.employeeId = employeeId;
    }
    public LeaveRequest( LocalDate startDate , LocalDate endDate , String leaveReason, String status, String supportingDocs, int leaveBalance, String type, int employeeId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveReason = leaveReason;
        this.status = status;
        this.supportingDocs = supportingDocs;
        this.leaveBalance = leaveBalance;
        this.type = type;
        this.employeeId = employeeId;
    }

    public int getLeaveRequestId() {
        return leaveRequestId;
    }
    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getLeaveReason() {
        return leaveReason;
    }
    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSupportingDocs() {
        return supportingDocs;
    }
    public void setSupportingDocs(String supportingDocs) {
        this.supportingDocs = supportingDocs;
    }
    public int getLeaveBalance() {
        return leaveBalance;
    }
    public void setLeaveBalance(int leaveBalance) {
        this.leaveBalance = leaveBalance;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
}
