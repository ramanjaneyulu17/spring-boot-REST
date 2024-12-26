package com.example.spring_boot_rest.controller;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJobPost(@PathVariable int postId){
        return service.getJobPost(postId);
    }

    @PostMapping("addJob")
    public void addJob(@RequestBody JobPost job){
         service.addJob(job);
    }

    @PutMapping("updatePost")
    public JobPost updatePost(@RequestBody JobPost post){
        service.updatePost(post);
        System.out.println("Updated.");
       return service.getJobPost(post.getPostId());
    }

    @DeleteMapping("deletePost/{postId}")
    public void deletePost(@PathVariable("postId") int postId){
        service.deletePost(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchPosts(@PathVariable("keyword")String keyword){
        return service.searchPosts(keyword);
    }

    @GetMapping("loadData")
    public String loadData(){
        service.loadData();
        return "loaded...";
    }
}
