package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Workers")
public class Worker extends AEntity{

    @Column(name = "LastName")
    private String lastName;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "Patronymic")
    private String patronymic;
    @Column(name = "Data")
    private LocalDate data;
    @OneToOne(mappedBy = "worker")
    private Issuance issuance;

    @Override
    public String toString() {
        return "Reader{id=" +getId()+
                ", lastName=" + lastName +
                ", firstname=" + firstName +
                ", patronymic=" + patronymic +
                ", data=" + data +
                "}";
    }
}
