package com.example.application;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class ControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }


    @Test
    public void getDataTest() throws Exception {
        String name;
        String uri = "/get-data?name=indrajeet";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
     ExampleModel model = super.mapFromJson(content, ExampleModel.class);
        assertTrue(!model.getName().isEmpty());
    }

}