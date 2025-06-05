package com.piseth.java.school.webflux_playgroud.session1;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"sec=session1","logging.level.org.springframework.r2dbc=DEBUG"})
public abstract class AbstractTest {

}
