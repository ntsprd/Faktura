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
import pl.connectis.cschool.jcourse.restservice.domain.Produkt;
import pl.connectis.cschool.jcourse.restservice.repository.ProduktRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProduktTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ProduktRepository pr;

    @Before
    public void setup() {

        mockMvc = webAppContextSetup(webApplicationContext).build();

        Produkt pt = new Produkt("Kaszanka", 10, 1, 2, 5.20);
        pr.save(pt);

    }

    @Test
    public void getProduktTest() throws Exception {

        mockMvc.perform(get("/products/1")).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$.nazwa", is("Kaszanka")));

               // andExpect();
    }

    @Test
    public void addProduktTest() throws Exception {

        String json = convertToJSON(new Produkt("Salceson", 5, 1, 1, 4.50));

        mockMvc.perform(post("/products").content(json).contentType(MediaType.APPLICATION_JSON_UTF8)).
        andExpect(status().isOk());

    }

    // Very very simple mapper TODO: improve it
    private String convertToJSON(Object o) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(o);
    }
}





































