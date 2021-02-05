package com.danny.BookStore.dao;


import com.danny.BookStore.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BookDao {

//    SELECT
//            book_id,
//            name,
//            number
//    FROM
//            book
//    WHERE
//    book_id = #{bookId}
    @Select("SELECT book_id,name,number FROM book WHERE book_id = #{bookId} ")
    Book queryById(@Param("bookId") long id);

    @Select("SELECT book_id,name,number FROM book ORDER BY book_id LIMIT #{limit} OFFSET #{offset}")
    List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    @Update("Update book SET number=number-1 WHERE book_id=#{bookId} AND number>0")
    int reduceNumber(@Param("bookId") long bookId);
    
}
