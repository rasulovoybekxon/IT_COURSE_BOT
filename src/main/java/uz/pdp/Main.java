package uz.pdp;

import uz.pdp.models.BotService;
import uz.pdp.models.Course;
import uz.pdp.models.Lesson;
import uz.pdp.models.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello from Javohir");
        User user = new User(2);
        System.out.println(user);


        Course java = new Course("JAVA", 7);
        System.out.println(java);

        Lesson lesson = Lesson.builder().name("Hello my branch").level("Beginner").number_course(10).build();

        System.out.println(lesson);

        BotService botService = new BotService("Bot");
        System.out.println(botService);
    }
}