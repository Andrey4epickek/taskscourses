package com.library.test;

import com.hotel.api.dao.IReaderDao;
import com.library.dao.ReaderDao;
import com.library.dao.configuration.JpaConfiguration;
import com.library.model.Reader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import static org.junit.Assert.*;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {JpaConfiguration.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class ReaderDaoTest {

    @Resource
    private IReaderDao readerDao;

    @Test
    public void testSave(){
        Reader reader=new Reader("dgd","dfg","dfg",20,null,null);
        readerDao.save(reader);

        Reader reader1= readerDao.getById(4);
        assertEquals("20",reader1.getAge());
    }
}
