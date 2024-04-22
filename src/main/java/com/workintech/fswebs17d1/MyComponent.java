package com.workintech.fswebs17d1;

import org.springframework.beans.factory.annotation.Value;

public class MyComponent {
    @Value("${course.name}")
    private String courseName;

    @Value("${project.developer.fullname}")
    private String developerFullName;

    public String getCourseName() {
        return courseName;
    }

    public String getDeveloperFullName() {
        return developerFullName;
    }
}
