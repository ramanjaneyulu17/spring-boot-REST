package com.example.spring_boot_rest.repo;

import com.example.spring_boot_rest.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class JobRepo {


    List<JobPost> jobs= new ArrayList<>(Arrays.asList(new JobPost(1, "Java Developer", "Must have good experience in core Java and advanced Java", 2, List.of("Core Java", "J2EE", "Spring Boot", "Hibernate")),
            new JobPost(2, "Frontend Developer", "Experience in building responsive web applications using React", 3, List.of("HTML", "CSS", "JavaScript", "React")),
            new JobPost(3, "Data Scientist", "Strong background in machine learning and data analysis", 4, List.of("Python", "Machine Learning", "Data Analysis"))));


    public List<JobPost> getAllJobs(){
        return jobs;
    }

    public void addJob(JobPost jobPost){
        jobs.add(jobPost);
    }

    public JobPost getJobPost(int postId) {
        for(JobPost job:jobs){
            if(job.getPostId()==postId){
                return job;
            }
        }
        return null;
    }

    public void updatePost(JobPost post) {
        for(JobPost job:jobs){
            if(job.getPostId()==post.getPostId()){
                job.setPostProfile(post.getPostProfile());
                job.setPostDesc(post.getPostDesc());
                job.setReqExperience(post.getReqExperience());
                job.setPostTechStack(post.getPostTechStack());
            }
        }
    }

    public void deletePost(int postId) {
        for(JobPost job:jobs){
            if(job.getPostId()==postId){
                jobs.remove(job);
            }
        }
    }
}
