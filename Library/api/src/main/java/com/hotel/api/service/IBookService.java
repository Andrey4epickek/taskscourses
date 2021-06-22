package com.hotel.api.service;

import com.library.model.Book;
import com.library.model.dto.BookDto;

import java.util.Date;
import java.util.List;

public interface IBookService {

    Book addBook(String title, Date data,String author,Integer god,String genre, Integer sum);
    BookDto getById(Integer bookId);
    List<BookDto> getAll();
    void deleteBook(Integer bookId);
    void updateSum();
}
