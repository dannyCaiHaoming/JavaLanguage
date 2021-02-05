package com.danny.BookStore.dao;

import com.danny.BookStore.BaseTest;
import com.danny.BookStore.entity.Appointment;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AppointmentDaoTest extends BaseTest {

    @Autowired
    private AppointmentDao appointmentDao;


    @Test
    public void testInert() throws Exception {
        Integer bookId = 1000;
        Integer studentId = 1000;
        int result = appointmentDao.insertAppointment(bookId, studentId);
        System.out.println("appointmentDao =" + appointmentDao);
        System.out.println("testInert =" + result);
    }

    @Test
    public void testqueryByKeyWithBook() throws  Exception{
        Integer bookId = 1000;
        Integer studentId = 1000;
        Appointment appointment = appointmentDao.queryByKeyWithBook(bookId,studentId);
        System.out.println(appointment);
    }
}
