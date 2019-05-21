/*package com.ws.sample.demo;

import com.shapestone.rest.jersey.client.factory.ClientFactory;
import com.ws.sample.demo.domain.Job;
import com.ws.sample.demo.web.rest.JobResource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.util.List;

@SpringBootApplication
public class ClientApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class,
                "--spring.application.name=job-client",
                "--server.port=3000"
        );
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //String address = "http://localhost:" + "8080";
        //JobResource store = JAXRSClientFactory.create(address, JobResource.class);
        //List<Job> b = store.getAllJobs();

Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080/");
        JobResource resource = WebResourceFactory.newResource(JobResource.class, target);
        resource.getAllJobs();



        ResourceBuilder builder = new ResourceBuilder();
        resource = builder.
                url("http://localhost:8080/").
                build(JobResource.class);
        client = resource.getAllJobs();


    }
}*/
