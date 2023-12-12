package com.mindex.challenge.data;

public class ReportingStructure {

    /**
     * represents the employee object
     */
    Employee employee;

    /**
     * the number of direct reports for this employee
     */
    int numberOfReports;

    public ReportingStructure() {

    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public int getNumberOfReports() {
        return this.numberOfReports;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }
}
