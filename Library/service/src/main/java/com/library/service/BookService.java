package com.library.service;

import com.hotel.api.dao.IBookDao;
import com.hotel.api.service.IBookService;
import com.hotel.exceptions.DaoException;
import com.hotel.exceptions.ServiceException;
import com.library.model.Book;
import com.library.model.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService implements IBookService {

    private static final Logger LOGGER= LogManager.getLogger(BookService.class.getName());
    private final IBookDao bookDao;
    private final ModelMapper mapper;

    @Override
    public Book addBook(String title, Date data, String author, Integer god, String genre, Integer sum) {
        try {
            LOGGER.info(String.format("Adding of book %s,genre %s",title,genre));
            Book book=new Book();
            book.setTitle(title);
            book.setData(data);
            book.setAuthor(author);
            book.setGod(god);
            book.setGenre(genre);
            book.setSum(sum);
            bookDao.save(book);
            return book;
        } catch (DaoException e) {
            LOGGER.warn("Adding of book failed",e);
            throw new ServiceException("Adding of book failed",e);
        }
    }

    @Override
    public BookDto getById(Integer bookId) {
        try {
            LOGGER.info(String.format("Getting of book %d",bookId));
            Book book=bookDao.getById(bookId);
            return mapper.map(book,BookDto.class);
        } catch (DaoException e) {
            LOGGER.warn("Getting of book failed",e);
            throw new ServiceException("Getting of book failed",e);
        }
    }

    @Override
    public List<BookDto> getAll() {
        try{
            LOGGER.info(String.format("Getting of all books"));
            List<Book> bookList=bookDao.getAll();
            bookList.sort(((o1, o2) -> o1.getGod()- o2.getGod()));
            List<BookDto> bookDtoList=new ArrayList<>();
            for(Book book:bookList){
                BookDto bookDto=mapper.map(book,BookDto.class);
                bookDtoList.add(bookDto);
            }
            return bookDtoList;
        } catch (DaoException e) {
            LOGGER.warn("Getting of all books failed",e);
            throw new ServiceException("Getting of all books failed",e);
        }
    }

    @Override
    public void deleteBook(Integer bookId) {
        try{
            LOGGER.info(String.format("Deleting of book %d",bookId));
            Book book=bookDao.getById(bookId);
            bookDao.delete(book);
        } catch (DaoException e) {
            LOGGER.warn("Deleting of book failed",e);
            throw new ServiceException("Deleting of book failed",e);
        }
    }

    @Override
    public void updateSum() {

    }
}
