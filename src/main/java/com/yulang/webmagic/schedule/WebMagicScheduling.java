package com.yulang.webmagic.schedule;

import com.yulang.webmagic.processor.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.ConsolePipeline;
import us.codecraft.webmagic.pipeline.FilePipeline;

@Component
public class WebMagicScheduling {

    @Autowired
    private MyProcessor myProcessor;


    @Scheduled(fixedDelay = 100000)
    public void execute(){
        Spider.create(myProcessor)
                .addUrl("https://www.cnblogs.com")
                .addPipeline(new ConsolePipeline())
                .addPipeline(new FilePipeline("D:\\data"))
                .start();
    }

}
