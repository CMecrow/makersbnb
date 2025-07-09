package com.makers.makersbnb.repository;

import com.makers.makersbnb.model.Staff;
import org.springframework.data.repository.CrudRepository;

// StaffRepository inherits from CrudRepository
// The type parameters 'Space' and 'Long' relate to the Model and id
// We're saying - this repository should create instances of Space
// and the ids of those spaces should be of type Long
public interface StaffRepository extends CrudRepository<Staff, Long> {
}
