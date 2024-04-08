package com.careerservice.jobservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Job(
        @NotBlank(message = "The job's jobid must be defined.")
        @Pattern(regexp = "^([0-9]|[0-9]{3})$", message = "The jobid format must be valid")
        String jobid,
        @NotBlank(message = "The job title must be defined.")
        String title,
        @NotBlank(message = "The job description must be defined.")
        String description,
        @NotBlank(message = "The job's company name must be defined.")
        String companyname,
        @NotBlank(message = "The job's skill1 must be defined.")
        String skill1,
        @NotBlank(message = "The job's skill2 must be defined.")
        String skill2) { }
