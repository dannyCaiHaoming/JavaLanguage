package com.danny.BookStore.dao;

import com.danny.BookStore.entity.Appointment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface AppointmentDao {


    @Insert("INSERT IGNORE INTO appointment (book_id,student_id) VALUES (#{bookId},#{studentId})")
    int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);


    //多表连接查询
    @Select("SELECT a.book_id,a.student_id,a.appoint_time," +
            " b.number name" +
            " FROM appointment a" +
            " INNER JOIN book b" +
            " ON a.book_id = b.book_id" +
            " WHERE a.book_id=#{bookId}" +
            " AND a.student_id = #{studentId}")
    Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);


//    SELECT
//    a.book_id,
//    a.student_id,
//    a.appoint_time,
//    b.book_id "book.book_id",
//    b.`name` "book.name",
//    b.number "book.number"
//    FROM
//    appointment a
//    INNER JOIN book b ON a.book_id = b.book_id
//            WHERE
//    a.book_id = #{bookId}
//    AND a.student_id = #{studentId}
}
