package controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.websocket.SendResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringRunner.class)
@WebMvcTest(TacoController.class)
public class HomeControllerTest {
    //

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception{
        mockMvc.perform(get("/"))
                .andExpect(status().isOK())
                .andExpect(view().name("home"))
                .andExpect(content().string(
                        containsString("Welcome to Toco Pizza")));
    }


}
