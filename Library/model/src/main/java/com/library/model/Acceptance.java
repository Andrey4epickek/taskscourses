package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Acceptance")
public class Acceptance extends AEntity{

    @OneToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @OneToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "Sum")
    private Integer sum;
    @Column(name = "Data")
    private LocalDate data;

    @Override
    public String toString() {
        return "Acceptance{id=" +getId()+
                ", worker=" + worker +
                ", reader=" + reader +
                ", book=" + book +
                ", sum=" + sum +
                ", data=" + data +
                "}";
    }
}
