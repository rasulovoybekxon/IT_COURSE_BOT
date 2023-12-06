package uz.pdp.service;

public class CourseService {
    public static CourseService courseService;

    public static CourseService getInstance() {
        if (courseService == null) {
            courseService = new CourseService();
        }
        return courseService;
    }
}
