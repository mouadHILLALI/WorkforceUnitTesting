package workforcemanger.workforce.dto;

import java.time.LocalDate;

public class FamilyAllowanceDTO {
    private int familyId;
    private int childrenCount;
    private Double allowanceAmount;
    private Double salaryAmount;
    private LocalDate dateCalculated;

    public FamilyAllowanceDTO() {}

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public Double getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(Double allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public Double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(Double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public LocalDate getDateCalculated() {
        return dateCalculated;
    }

    public void setDateCalculated(LocalDate dateCalculated) {
        this.dateCalculated = dateCalculated;
    }
}
