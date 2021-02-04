package com.danny.BookStore.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Appoitment {

    private long bookId;

    private long studentId;

    private Date appointTime;

    private Book book;

}
