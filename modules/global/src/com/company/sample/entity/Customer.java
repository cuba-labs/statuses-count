package com.company.sample.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "SAMPLE_CUSTOMER")
@Entity(name = "sample$Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -1408948157594396049L;

    @Column(name = "NAME", length = 50, nullable = false)
    protected String name;

    @Column(name = "LAST_NAME", length = 100, nullable = false)
    protected String lastName;

    @Column(name = "AGE")
    protected Integer age;

    @Column(name = "GRADE")
    protected Integer grade;

    public void setGrade(CustomerGrade grade) {
        this.grade = grade == null ? null : grade.getId();
    }

    public CustomerGrade getGrade() {
        return grade == null ? null : CustomerGrade.fromId(grade);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }
}