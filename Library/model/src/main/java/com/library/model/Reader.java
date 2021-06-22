package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Readers")
public class Reader extends AEntity{

    @Column(name = "LastName")
    private String lastName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "Ptronymic")
    private String patronymic;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Data")
    private Date data;
    @OneToOne(mappedBy = "reader")
    private Issuance issuance;

    @Override
    public String toString() {
        return "Reader{id=" +getId()+
                ", lastName=" + lastName +
                ", firstname=" + firstName +
                ", patronymic=" + patronymic +
                ", age=" + age +
                ", data=" + data +
                "}";
    }
}
