package com.yulang.webmagic.processor;

import com.yulang.webmagic.dao.ArticleMapper;
import com.yulang.webmagic.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;
import us.codecraft.webmagic.selector.XpathSelector;

import java.util.Date;


/**
 * 爬取类
 */
@Component
public class MyProcessor implements PageProcessor {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void process(Page page) {
        page.setCharset("UTF-8");
        page.addTargetRequests(page.getHtml().links().regex("https://588ku.com/gif/[a-z]+.html").all());
        XpathSelector select = new XpathSelector("/html/body/div[5]/div[2]/div/div[1]");
        Selectable res = page.getHtml().select(select);
        page.putField("title",res.toString());
        Article article = new Article();
        article.setTitle(res.toString());
        article.setCreateTime(new Date());
        // articleMapper.insert(article);

    }

    @Override
    public Site getSite() {
        return Site.me().setSleepTime(1000).setRetryTimes(3);
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setUrl("https://588ku.com");
        Spider.create(new MyProcessor())
                .addRequest(request)
                .addUrl("https://588ku.com")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new FilePipeline("D:\\data"))
                .start();
    }
}
