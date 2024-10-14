package com.naveen.curddemo.jparepo;

import com.naveen.curddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
// Defining custom entity path
// use /members instead of /entity
@RepositoryRestResource(path = "members")
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {
    // That's it naveen
    // all the standard methods are extended and can be used now
}
