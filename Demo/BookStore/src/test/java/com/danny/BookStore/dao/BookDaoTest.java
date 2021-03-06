package com.danny.BookStore.dao;

import com.danny.BookStore.AppConfig;
import com.danny.BookStore.BaseTest;
import com.danny.BookStore.dao.BookDao;
import com.danny.BookStore.entity.Book;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest {
    @Autowired
    BookDao bookDao;

    @Autowired
    AppConfig appConfig;

    @Test
    public void testQueryById() throws Exception {
//        long bookId = 1000;
//        Book book = bookDao.queryById(bookId);
//        System.out.println(book);

        System.out.println(appConfig);
    }

    @Test
    public void testQueryAll() throws Exception {
        List<Book> books = bookDao.queryAll(0, 4);
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testReduceNumber() throws Exception {
        long bookId = 1000;
        int update = bookDao.reduceNumber(bookId);
        System.out.println("update=" + update);
    }
}
