package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Issuance")
public class Issuance extends AEntity{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "reader_id")
    private Reader reader;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;
    @Column(name = "Sum")
    private Integer sum;
    @Column(name = "Time")
    private Integer time;
    @Column(name = "Data")
    private Date data;

    @Override
    public String toString() {
        return "Issuance{id=" +getId()+
                ", worker=" + worker +
                ", reader=" + reader +
                ", book=" + book +
                ", sum=" + sum +
                ", time=" + time +
                ", data=" + data +
                "}";
    }
}
