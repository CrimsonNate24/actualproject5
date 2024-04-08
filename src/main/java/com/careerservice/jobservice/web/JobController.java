package com.careerservice.jobservice.web;
import com.careerservice.jobservice.domain.Job;
import com.careerservice.jobservice.domain.JobService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("job")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobservice){
        this.jobService = jobservice;
    }

    @GetMapping
    public Iterable<Job> get(){
        return jobService.viewJobList();
    }

    @GetMapping("{jobid}")
    public Job getByJobid(@PathVariable String jobid){
        return jobService.viewJobDetails(jobid);
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Job post(@Valid @RequestBody Job job){return jobService.addJobToDatabase(job);}

    @DeleteMapping("{jobid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable String jobid){
        jobService.removeJobFromDatabase(jobid);
    }

    @PutMapping("{jobid}")
    public Job put(@PathVariable String jobid, @Valid @RequestBody Job job){
        return jobService.editJobDetails(jobid, job);
    }
}
