package com.jingtuo.controller;

import com.jingtuo.pojo.Chapter;
import com.jingtuo.service.IChapterService;
import com.jingtuo.service.impl.ChapterServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Crested by 张鹏
 * Date 2018/12/26 8:58
 * version:1.0
 */
@Controller
@RequestMapping("/chapter")
public class ChapterController {

    /**
     * 查询章节列表
     * @param bookId
     * @param model
     * @return
     */
    @RequestMapping("/toChapterList")
    public String toChapterList(@RequestParam int bookId , Model model){
        IChapterService iChapterService = new ChapterServiceImpl();
        List<Chapter> chapters = iChapterService.findChapters(bookId);
        model.addAttribute("chapters",chapters);
        return "chapterList";
    }

    /**
     * 查询单章节内容
     * @param bookId
     * @param chapterNum
     * @param model
     * @return
     */
    @RequestMapping("/findContentById")
    public String findContentById(@RequestParam int bookId ,@RequestParam int chapterNum ,Model model){
        IChapterService iChapterService = new ChapterServiceImpl();
        Chapter chapter = iChapterService.findContentById(bookId ,chapterNum);
        model.addAttribute("chapter",chapter);
        return "chapterContent";
    }
}
