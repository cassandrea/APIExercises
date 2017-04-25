package com.apiexercises.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * POJO that corresponds to the departments table in the employees database
 *
 * @author cass
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Department {
    private int id;
    private String dept_name;

    public int getDept_no() {
        return id;
    }

    public void setDept_no(String dept_no) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", dept_name='" + dept_name + '\'' +
                '}';
    }
}
