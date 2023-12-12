package com.mindex.challenge.data;
import java.util.Date;
import java.util.Objects;

public class Compensation {

    private Employee employee;

    private String salary;

    private Date effectiveDate;


    public Compensation() {
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getSalary() {
        return this.salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Compensation) {
            Compensation compensation = (Compensation) o;
            return Objects.equals(employee, compensation.employee)
                    && salary.equals(compensation.salary)
                    && Objects.equals(effectiveDate, compensation.effectiveDate);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee, salary, effectiveDate);
    }
}
