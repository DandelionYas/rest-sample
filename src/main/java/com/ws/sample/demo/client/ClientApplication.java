package com.ws.sample.demo.client;

import com.ws.sample.demo.domain.Job;
import com.ws.sample.demo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ClientApplication {
    private static final String BASE_ADDRESS = "http://localhost:8082";

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String token = restTemplate.postForObject(BASE_ADDRESS + "/api/login/", new User(), String.class);
        Job job = new Job();
        job.setTitle("Java Developer");
        ResponseEntity<Job> jobResponseEntity = restTemplate.postForEntity(BASE_ADDRESS + "/api/jobs/", job, Job.class);
        Job body = jobResponseEntity.getBody();
        body.setTitle("Java Backend Developer");
        restTemplate.put(BASE_ADDRESS + "/api/jobs/", body);
        List<Job> allJobs = restTemplate.getForObject(BASE_ADDRESS + "/api/jobs/", List.class);
        restTemplate.delete(BASE_ADDRESS + "/api/jobs/1");
        System.out.println();
    }
}
