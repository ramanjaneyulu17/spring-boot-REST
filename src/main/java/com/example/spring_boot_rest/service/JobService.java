package com.example.spring_boot_rest.service;

import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo repo;

    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }
    public List<JobPost> getAllJobs(){
        return  repo.findAll();
    }

    public JobPost getJobPost(int postId) {
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updatePost(JobPost post) {
        repo.save(post);
    }

    public void deletePost(int postId) {
        repo.deleteById(postId);
    }

    public void loadData() {
        List<JobPost> jobs= new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
                new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
                new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis"))));

        repo.saveAll(jobs);
    }
}
