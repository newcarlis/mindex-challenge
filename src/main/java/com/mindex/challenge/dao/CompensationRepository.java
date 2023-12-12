package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {

    /**
     * find the related compensation record based on the employee info
     * @param employee the employee object to use as key
     * @return compensation record
     */
    Compensation findCompensationByEmployee(Employee employee);
}