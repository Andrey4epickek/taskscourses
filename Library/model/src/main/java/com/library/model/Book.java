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
@Table(name = "Books")
public class Book extends AEntity{

    @Column(name = "Title")
    private String title;
    @Column(name = "Data")
    private Date data;
    @Column(name = "Author")
    private String author;
    @Column(name = "God")
    private Integer god;
    @Column(name = "Genre")
    private String genre;
    @Column(name = "Sum")
    private Integer sum;
    @OneToOne(mappedBy = "book")
    private Issuance issuance;

    @Override
    public String toString() {
        return "Book{id=" +getId()+
                ", title=" + title +
                ", data=" + data +
                ", author=" + author +
                ", god=" + god +
                ", genre=" + genre +
                ", sum=" + sum +
                "}";
    }
}
