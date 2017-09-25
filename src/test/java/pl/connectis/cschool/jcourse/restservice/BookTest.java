package pl.connectis.cschool.jcourse.restservice;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.connectis.cschool.jcourse.restservice.domain.Book;
import pl.connectis.cschool.jcourse.restservice.repository.BookRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class BookTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private BookRepository br;

    @Before
    public void setup() {

        mockMvc = webAppContextSetup(webApplicationContext).build();

        Book pt = new Book("Pan Tadeusz");
        br.save(pt);

    }

    @Test
    public void getBookTest() throws Exception {

        mockMvc.perform(get("/books/1")).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$.title", is("Ogniem i Mieciem")));

               // andExpect();


    }

    @Test
    public void addBookTest() throws Exception {

        String json = convertToJSON(new Book("Potop"));

        mockMvc.perform(post("/books").content(convertToJSON(json)).contentType(MediaType.APPLICATION_JSON_UTF8)).
        andExpect(status().isOk());

    }

    // Very very simple mapper TODO: improve it
    private String convertToJSON(Object o) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(o);
    }
}





































