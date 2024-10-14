package workforcemanger.workforce.dto;

import workforcemanger.workforce.enums.StatusEnum;

import java.time.LocalDate;

public class LeaveRequestDTO {
    private int leaveRequestId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String leaveReason;
    private String status;
    private String supportingDocs;
    private int leaveBalance;
    private int employeeId;
    private String type;

    public LeaveRequestDTO() {}

    public LeaveRequestDTO(int leaveRequestId, LocalDate startDate, LocalDate endDate, String leaveReason, String status, String supportingDocs, int leaveBalance, int employeeId , String type) {
        this.leaveRequestId = leaveRequestId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveReason = leaveReason;
        this.status = status;
        this.supportingDocs = supportingDocs;
        this.leaveBalance = leaveBalance;
        this.employeeId = employeeId;
        this.type = type;
    }
    public LeaveRequestDTO( LocalDate startDate, LocalDate endDate, String leaveReason, String status, String supportingDocs, int leaveBalance, int employeeId , String type ) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.leaveReason = leaveReason;
        this.status = status;
        this.supportingDocs = supportingDocs;
        this.leaveBalance = leaveBalance;
        this.employeeId = employeeId;
        this.type = type;
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

    @Override
    public String toString() {
        return "LeaveRequestDTO{" +
                "leaveRequestId=" + leaveRequestId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", leaveReason='" + leaveReason + '\'' +
                ", status=" + status +
                ", supportingDocs='" + supportingDocs + '\'' +
                ", leaveBalance=" + leaveBalance +
                ", employeeId=" + employeeId +
                '}';
    }
}
