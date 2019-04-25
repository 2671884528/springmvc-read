package com.jingtuo.service.impl;

import com.jingtuo.dao.ChapterDao;
import com.jingtuo.pojo.Chapter;
import com.jingtuo.service.IChapterService;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 9:02
 * version:1.0
 */
public class ChapterServiceImpl implements IChapterService {

    /**
     * 查询章节列表
     * @param bookId
     * @return
     */
    @Override
    public List findChapters(int bookId) {
        ChapterDao chapterDao = new ChapterDao();
        return chapterDao.findChapters(bookId);
    }

    /**
     * 查询但章节内容
     * @param bookId
     * @param chapterNum
     * @return
     */
    @Override
    public Chapter findContentById(int bookId, int chapterNum) {
        ChapterDao chapterDao = new ChapterDao();
        return chapterDao.findContentById(bookId ,chapterNum);
    }
}
