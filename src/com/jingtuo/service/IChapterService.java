package com.jingtuo.service;

import com.jingtuo.pojo.Chapter;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 9:01
 * version:1.0
 */
public interface IChapterService {

    /**
     * 查询章节列表
     * @param bookId
     * @return
     */
    public List findChapters(int bookId);

    /**
     * 查询但章节内容
     * @param bookId
     * @param chapterNum
     * @return
     */
    public Chapter findContentById(int bookId ,int chapterNum);
}
