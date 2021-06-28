package com.library.test;

import com.hotel.api.service.IReaderService;
import com.library.dao.ReaderDao;
import com.library.model.Reader;
import com.library.service.ReaderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;


public class ReaderDaoTest {

    ApplicationContext context=new ClassPathXmlApplicationContext("appContext.xml");
    ReaderDao readerDao=context.getBean(ReaderDao.class);

    @Test
    public void testSave(){

        Reader reader=new Reader("dfg","sfgd","dgdfg",20,null,null,null);
        readerDao.save(reader);

        Reader reader1= readerDao.getById(6);
        assertEquals("20",reader1.getAge());
    }
}
