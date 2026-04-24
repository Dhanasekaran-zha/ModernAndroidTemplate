package com.data.mapper

import com.data.remote.dto.responses.Candidates
import com.database.entities.EmployeeEntity
import com.domain.model.Employee

fun Candidates.toEmployee() : Employee{
    return Employee(
        id = id,
        fullName = name,
        phone = phoneNumber,
        position = jobTitle
    )
}