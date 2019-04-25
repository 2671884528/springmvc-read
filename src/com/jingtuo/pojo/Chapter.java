package com.jingtuo.pojo;

/**
 * Crested by 张鹏
 * Date 2018/12/26 8:54
 * version:1.0
 */
public class Chapter {

    private int chapterNum;
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String chapterName;
    private String chapterContent;

    public int getChapterNum() {
        return chapterNum;
    }

    public void setChapterNum(int chapterNum) {
        this.chapterNum = chapterNum;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getLastChapterNum() {
        return chapterNum-1;
    }

    public int getNextChapterNum() {
        return chapterNum+1;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getChapterContent() {
        return chapterContent;
    }

    public void setChapterContent(String chapterContent) {
        this.chapterContent = chapterContent;
    }
}
