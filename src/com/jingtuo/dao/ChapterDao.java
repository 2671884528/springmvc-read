package com.jingtuo.dao;

import com.jingtuo.pojo.Chapter;
import com.jingtuo.utils.DBUtilsPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 8:59
 * version:1.0
 */
public class ChapterDao {

    /**
     * 查询章节列表
     * @param bookId
     * @return
     */
    public List findChapters(int bookId){
        List<Chapter> chapters = new ArrayList<>();
        //获取数据库连接
        Connection connection = DBUtilsPool.getConnection();
        //创建sql
        String sql = "select chapter_name ,chapter_num from chapters where book_id =" +bookId;
        try {
            //预编译
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //执行sql
            ResultSet resultSet = preparedStatement.executeQuery();
            //查询书名和作者名
            String sql2 = "select book_name ,author from books where id = "+bookId;
            preparedStatement = connection.prepareStatement(sql2);
            ResultSet resultSet2 = preparedStatement.executeQuery();
            String bookName = "佚名";
            String author = "佚名";
            while (resultSet2.next()){
                bookName = resultSet2.getString("book_name");
                author=resultSet2.getString("author");
            }
            while(resultSet.next()){
                Chapter chapter = new Chapter();
                chapter.setBookId(bookId);
                chapter.setBookName(bookName);
                chapter.setBookAuthor(author);
                chapter.setChapterNum(resultSet.getInt("chapter_num"));
                chapter.setChapterName(resultSet.getString("chapter_name"));
                chapters.add(chapter);
            }
            Collections.sort(chapters, new Comparator<Chapter>() {
                //按照章节数升序排序
                @Override
                public int compare(Chapter o1, Chapter o2) {
                    if(o1.getChapterNum() > o2.getChapterNum()){
                        return 1;
                    }
                    if (o1.getChapterNum() == o2.getChapterNum()){
                        return 0;
                    }
                    return -1;
                }
            });
            resultSet.close();
            resultSet2.close();
            preparedStatement.close();
            DBUtilsPool.release(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapters;
    }

    /**
     * 查询单章节内容
     * @param bookId
     * @param chapterNum
     * @return
     */
    public Chapter findContentById(int bookId ,int chapterNum){
        Chapter chapter = new Chapter();
        //从数据库连接池获取连接
        Connection connection = DBUtilsPool.getConnection();
        //创建sql
        String sql = "select chapter_name ,chapter_content from chapters where book_id ="+bookId+" and chapter_num ="+chapterNum;
        try {
            //预编译
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //执行sql
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                chapter.setChapterNum(chapterNum);
                chapter.setBookId(bookId);
                chapter.setChapterName(resultSet.getString("chapter_name"));
                chapter.setChapterContent(resultSet.getString("chapter_content"));
            }
            resultSet.close();
            preparedStatement.close();
            DBUtilsPool.release(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chapter;
    }

}
