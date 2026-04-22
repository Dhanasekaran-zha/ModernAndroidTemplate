package com.data.mapper

import com.database.entities.EmployeeEntity
import com.domain.model.Employee

//
//// DTO to Domain
//fun EmployeeDto.toDomain(): Employee {
//    return Employee(
//        id = id,
//        fullName = "$firstName $lastName",
//        email = email,
//        position = role
//    )
//}

// Entity to Domain
fun EmployeeEntity.toDomain(): Employee {
    return Employee(
        id = id,
        fullName = name,
        email = email,
        position = department
    )
}

// Domain to Entity (for caching)
fun Employee.toEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        name = fullName,
        email = email,
        department = position
    )
}