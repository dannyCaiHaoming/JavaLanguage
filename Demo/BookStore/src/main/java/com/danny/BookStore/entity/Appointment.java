package com.danny.BookStore.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Appointment {

    private long bookId;

    private long studentId;

    private Date appointTime;

    private Book book;

}
