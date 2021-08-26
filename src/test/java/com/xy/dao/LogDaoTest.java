package com.xy.dao;


import com.xy.model.LogModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogDaoTest {

    @Autowired
    private LogDao logDao;

    @Test
    public void save(){
        LogModel logModel = new LogModel();

        logModel.setStartTime(LocalDateTime.now());
        logModel.setEndTime(LocalDateTime.now());
        logDao.save(logModel);
    }
}
