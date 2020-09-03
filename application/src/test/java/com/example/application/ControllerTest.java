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



    //in case you're using @PreAuthorize in your APIs to for OAuth then you can uncomment the line below to mock user and replace the user role according to yours
    //@WithMockUser(roles="Admin")

    @Test     // test for get mapping
    public void getDataTest() throws Exception {

        String uri = "/get-data?name=indrajeet";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
     ExampleModel model = super.mapFromJson(content, ExampleModel.class);
        assertTrue(!model.getName().isEmpty());
    }



    @Test
    public void createDataTest() throws Exception {
        String uri = "/create-data";
        //preparing data to test
        ExampleModel model = new ExampleModel();
        model.setId(3);
        model.setName("example name");
        String inputJson = super.mapToJson(model);

        //running API
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        //testing results.
        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content,String.format("data %d is successfully created",model.getId()));
    }




    @Test
    public void updateDataTest() throws Exception {
        String uri = "/update-data";
        //preparing data to test
        ExampleModel model = new ExampleModel();
        model.setId(3);
        model.setName("example update name");
        String inputJson = super.mapToJson(model);

        //running API
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        //testing results.
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content,"data is successfully updated");
    }


    @Test
    public void deleteDataTest() throws Exception {
        Integer parameter = 2;
        String uri = "/delete-data?id="+parameter;


        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Data is deleted successfully");
    }
}




