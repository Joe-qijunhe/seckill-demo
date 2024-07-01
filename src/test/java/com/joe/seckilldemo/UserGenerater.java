package com.joe.seckilldemo;

import com.joe.seckilldemo.entity.User;
import com.joe.seckilldemo.service.IUserService;
import com.joe.seckilldemo.utils.UUIDUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class UserGenerater {
    @Autowired
    IUserService tUserService;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void CreateUser()  {
        String csvFile = "config.csv";
        List<User> list = new ArrayList<>();
        List<List<String>> csvData = new ArrayList<>();
//        生成用户
        for (int i = 0; i < 200; i++) {
            //生成用户
            User tUser = new User();
            long id = 1233L + i;
            tUser.setId(id);
            tUser.setNickname("user" + i);
            tUser.setSalt("1a2b3c");
            tUser.setPassword("1d9aab37a00a0330d5ad08f40d0a4d40");
            //假装登录
            String userTicket = UUIDUtil.uuid();
            redisTemplate.opsForValue().set("user:" + userTicket, tUser);
            csvData.add(Arrays.asList(id+"", userTicket));
            list.add(tUser);
        }
        tUserService.saveBatch(list);
        try (FileWriter writer = new FileWriter(csvFile)) {
            // 写入数据
            for (List<String> row : csvData) {
                for (int i = 0; i < row.size(); i++) {
                    writer.append(row.get(i));
                    if (i < row.size() - 1) {
                        writer.append(",");
                    }
                }
                writer.append("\n");
            }

            System.out.println("CSV文件创建成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
