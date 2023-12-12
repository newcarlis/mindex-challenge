package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.CompensationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompensationRepository compensationRepository;

    /**
     * Creates a new Compensation record for the specified employee.
     *
     * @param compensation The Compensation object to be created.
     * @return The created Compensation object.
     * @throws RuntimeException if the associated employee is not found.
     */
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating compensation: [{}]", compensation);
        Employee employee = employeeService.read(compensation.getEmployee().getEmployeeId());
        compensation.setEmployee(employee);
        compensationRepository.insert(compensation);

        return compensation;
    }

    /**
     * Retrieves the Compensation record for the specified employee ID.
     *
     * @param employeeId The ID of the employee for whom to retrieve the Compensation record.
     * @return The Compensation record associated with the provided employee ID.
     * @throws RuntimeException if no compensation record is found for the specified employee.
     */
    @Override
    public Compensation read(String employeeId) {
        LOG.debug("Reading compensation for employeeId: [{}]", employeeId);
        Employee employee = employeeService.read(employeeId);
        Compensation compensation = compensationRepository.findCompensationByEmployee(employee);
        if (compensation == null) {
            throw new RuntimeException("No compensation record for employee: " + employeeId);
        }
        return compensation;
    }

}