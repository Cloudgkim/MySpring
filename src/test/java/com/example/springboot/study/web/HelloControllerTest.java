package com.example.springboot.study.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

//아래의 import 3개는 직접 작성
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/* A003
 자동임포트 : Alt + Enter

 @ExtendWith : Junit4에서는 @RunWith에 해당
    스프링 부트 테스트와 Junit 연결 하는 기능을 수행
 @WebMvcTest
    @Controller, @ControllerAdvice 등을 사용 가능하게
    Service, Repository 등에서는 사용할 수 없다.
*/

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void helloReturnTest() throws Exception {

        String hello = "hello";

        // method chain
        // a().b().c()

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) // 200 OK
                .andExpect(content().string(hello));
    }
}
