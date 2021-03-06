package com.xiaoxiao.hotal.service;

import com.xiaoxiao.hotal.ApplicationTest;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@ContextConfiguration(classes = ApplicationTest.class)
public class BaseTest {

}
