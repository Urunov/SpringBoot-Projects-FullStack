package spring.database.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import spring.database.exception.ResourceNotFoundException;
import spring.database.model.Job;
import spring.database.repository.JobRepository;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: apple
 * @created on 01/04/2020
 * @Project is SpringJerseyJPA
 */

@Component
@Path("/api/")
public class JobResource {
    //
    @Autowired
    private JobRepository jobRepository;

    @GET
    @Produces("application/json")
    @Path("/jobs")
    public List<Job> getAllJobs(){
        return jobRepository.findAll();
    }

    @GET
    @Produces("application/json")
    @Path("/jobs")
    public ResponseEntity<Job> getJobById(@PathVariable(value = "id") Long jobId) throws ResourceNotFoundException{
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new ResourceNotFoundException("Job not found ::" + jobId));
        return ResponseEntity.ok().body(job);
    }

    @POST
    @Produces("appliction/json")
    @Consumes("application/json")
    @Path("/jobs")
    @PostMapping("/jobs")
    public Job createJob(Job job){
        return jobRepository.save(job);
    }

    @PUT
    @Consumes("application/json")
    @Path("/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathParam(value = "id") Long jobId, @Valid @RequestBody Job jobDetails) throws ResourceNotFoundException {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()->new ResourceNotFoundException("Job not found::" + jobId));
        job.setEmailId(jobDetails.getEmailId());
        job.setLastName(jobDetails.getLastName());
        job.setFirstName(jobDetails.getFirstName());
        final Job updateJob = jobRepository.save(job);
        return ResponseEntity.ok(updateJob);
    }

    @DELETE
    @Path("/jobs/{id}")
    public Map<String, Boolean> deleteJob (@PathParam(value = "id") Long jobId) throws ResourceNotFoundException{
        Job job = jobRepository.findById(jobId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found::" + jobId));

        jobRepository.delete(job);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.FALSE);
        return response;
    }
}
