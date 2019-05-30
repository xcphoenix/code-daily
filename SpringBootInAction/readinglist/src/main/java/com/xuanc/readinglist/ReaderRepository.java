package com.xuanc.readinglist;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName    readinglist-ReaderRepository
 * Description  通过 JPA 持久化读者
 *
 * @author      xuanc
 * @date        19-5-27 下午3:18
 * @version     1.0
 */ 
public interface ReaderRepository extends JpaRepository<Reader,String> {
}
