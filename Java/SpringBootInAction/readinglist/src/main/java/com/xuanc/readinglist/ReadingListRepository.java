package com.xuanc.readinglist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName    readinglist-ReadingListRepository
 * Description  定义仓库接口
 *              定义用于把 Book 对象持久化到数据库的仓库
 *              通过扩展 JpaRepository , ReadingListRepository 直接继承了18个执行常用持久化操作
 *              的方法。
 * @author      xuanc
 * @date        19-5-27 上午11:32
 * @version     1.0
 */ 
public interface ReadingListRepository extends JpaRepository<Book, Long> {
    List<Book> findByReader(String reader);
}
