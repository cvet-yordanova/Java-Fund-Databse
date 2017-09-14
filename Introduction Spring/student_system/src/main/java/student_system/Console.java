package student_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import student_system.entities.Course;
import student_system.entities.Homework;
import student_system.entities.Resource;
import student_system.entities.Student;
import student_system.service.impl.CourseServiceImpl;
import student_system.service.impl.HomeworkServiceImpl;
import student_system.service.impl.ResourceServiceImpl;
import student_system.service.impl.StudentServiceImpl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class Console implements CommandLineRunner{

    @Autowired
    private final CourseServiceImpl courseService;
    @Autowired
    private final HomeworkServiceImpl homeworkService;
    @Autowired
    private final ResourceServiceImpl resourceService;
    @Autowired
    private final StudentServiceImpl studentService;

    public Console(CourseServiceImpl courseService, HomeworkServiceImpl homeworkService, ResourceServiceImpl resourceService, StudentServiceImpl studentService) {
        this.courseService = courseService;
        this.homeworkService = homeworkService;
        this.resourceService = resourceService;
        this.studentService = studentService;
    }


    @Override
    public void run(String... strings) throws Exception {

//        seedRandomCourses();
//
        List<Course> courses = courseService.findAll();
//
//        seedRandomResources(courses);
//
//        seedRandomStudents(courses);
//
        List<Student> students = studentService.findAll();
//
//        seedRandomHomework(courses, students);

        //7 working with the database

//        listStudentsAndTheirHomewrok(students);

//        listCoursesAndTheirResources(courses);

//        List<ArrayList> allTheLists;
//
//        GetCoursesOrderedByCountResourcesDescAndStartDateDesc(courses);

        listActiveCoursesOnGivenDate();


    }

    private void listActiveCoursesOnGivenDate() throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("d/M/yyyy");
        List<Course> coursesActive = courseService
                .findByStartDateBeforeAndEndDateAfter(formatDate.parse("07/04/2006"),formatDate.parse("07/04/2006"));
        coursesActive
                .stream()
                .sorted((a,b) -> {
                    int result = 0;
                    if(a.getStudents().size() > b.getStudents().size()){
                        result =  -1;
                    }
                    else if(a.getStudents().size() < b.getStudents().size()){
                        result =  1;
                    }
                    else if(a.getStudents().size() == b.getStudents().size()){
                        long diffInMillies1 = a.getEndDate().getTime() - b.getStartDate().getTime();
                        long diffInMillies2 = a.getEndDate().getTime() - b.getStartDate().getTime();
                        if(diffInMillies1 > diffInMillies2){
                            result = -1;
                        }
                        else {
                            result = 1;
                        }
                    }

                    return result;
                }).forEach(a -> {
            long diffInMillies = a.getEndDate().getTime() - a.getStartDate().getTime();

            System.out.println(a.getName()+" Start date: "+a.getStartDate()+" End date: "+a.getEndDate());
            System.out.println("----"+ TimeUnit.MILLISECONDS.convert(diffInMillies, TimeUnit.DAYS)+" days difference.");
        });
    }

    private void listCoursesAndTheirResources(List<Course> courses) {
        courses.stream().sorted((a,b) -> {
                int result = a.getStartDate().compareTo(b.getStartDate());

                if(result == 0){
                    result = b.getEndDate().compareTo(a.getEndDate());
                }
                return result;
        }).forEach(a -> {
            System.out.println(a.getName()+" "+a.getDescription()+" "+a.getStartDate());
            List<Resource> resources = a.getResources();
            for (Resource resource : resources) {
                System.out.println("--"+resource.toString());
            }
        });
    }

    private void listStudentsAndTheirHomewrok(List<Student> students) {
        for (Student student : students) {

            System.out.println(student.getName());

            for (Homework homework : student.getHomeworkList()) {
                System.out.println("---Content: "+homework.getContent() + " Content type: "+homework.getContentType());
            }
        }
    }

    private void seedRandomHomework(List<Course> courses, List<Student> students) throws ParseException {

        Random random = new Random();
        String[] dates1 = {"2010\\04\\01","2010\\01\\03","2012\\05\\10","2013\\07\\01"};
        String[] homeworkContent = {"content1","content2"};
        String[] contentType = {".zip",".rar","jpeg","png",".doc","ppt"};
        String[] phoneNumbers = {"09708","98985987","695965","568764"};
        SimpleDateFormat dateFormat = new SimpleDateFormat("Y\\M\\d");
        for (int j = 0; j < phoneNumbers.length; j++) {

            int date1 = random.nextInt(dates1.length);
            int idxHomeworkContent = random.nextInt(homeworkContent.length);
            int idxContentType = random.nextInt(contentType.length);

            Homework homework = new Homework(homeworkContent[idxHomeworkContent]
                    ,contentType[idxContentType]
                    ,dateFormat.parse(dates1[date1])
                    ,courses.get(random.nextInt(courses.size()))
                    ,students.get(random.nextInt(students.size()))
            );

            homeworkService.saveHomework(homework);

        }
    }

    private void seedRandomStudents(List<Course> courses) throws ParseException {

        Random random = new Random();
        String[] dates1 = {"2010\\04\\01","2010\\01\\03","2012\\05\\10","2013\\07\\01"};
        String[] names = {"Marta Georgieva","Viktoria Ivanova","Antoniq Petrova","Petko Todorov","Atanas Ivailov","Hristo Kovalchev"};
        String[] phoneNumbers = {"09708","98985987","695965","568764"};


        for (int j = 0; j < phoneNumbers.length; j++) {

            int date1 = random.nextInt(dates1.length);
            int idxNames = random.nextInt(names.length);
            int idxPhoneNumber = random.nextInt(phoneNumbers.length);
            SimpleDateFormat dateFormat = new SimpleDateFormat("Y\\M\\d");

            Student student = new Student(names[idxNames]
                    ,phoneNumbers[idxPhoneNumber]
                    ,dateFormat.parse(dates1[date1]),
                    dateFormat.parse(dates1[date1]));
            List<Course> studentCourses = new ArrayList<>();
            studentCourses.add(courses.get(random.nextInt(courses.size())));
            studentCourses.add(courses.get(random.nextInt(courses.size())));
            studentCourses.add(courses.get(random.nextInt(courses.size())));

            student.setCourses(studentCourses);
            studentService.saveStudent(student);
        }
    }

    private void seedRandomResources(List<Course> courses) {
        for (int j = 0; j < 10; j++) {

            Random random = new Random();
            String[] resources = {"resource1","resource2","resource3"};
            String[] typeResources = {"video","presentation","book","site"};
            String[] URLs = {"wikipedia.org","resources.com","softuni.bg"};

            int idxResource = random.nextInt(resources.length);
            int idxTypeResource = random.nextInt(typeResources.length);
            int idxURL = random.nextInt(URLs.length);
            Resource resource = new Resource(resources[idxResource]
                    ,typeResources[idxTypeResource]
                    ,URLs[idxURL]
                    ,courses.get(random.nextInt(courses.size())));

            resourceService.saveResource(resource);

        }
    }

    private void seedRandomCourses() throws ParseException {
        String[] courseNames = {"Maths","Geography", "Art","Chemistry","Biology","IT"};
        String[] dates1 = {"2010\\04\\01","2010\\01\\03","2012\\05\\10","2013\\07\\01"};
        String[] dates2 = {"2014\\04\\01","2014\\05\\05","2017\\08\\08","2016\\02\\02"};
        String[] prices = {"200","300","120","1000","350","600"};

        Random random = new Random();
        SimpleDateFormat dateFormat = new SimpleDateFormat("Y\\M\\d");

        for (int i = 0; i < 10; i++) {

            int idxCourseName = random.nextInt(courseNames.length);
            int date1 = random.nextInt(dates1.length);
            int date2 = random.nextInt(dates2.length);
            int idxPrice = random.nextInt(prices.length);

            Course course = new Course(courseNames[idxCourseName]
                    ,null
                    ,dateFormat.parse(dates1[date1])
                    ,dateFormat.parse(dates2[date2])
                    ,new BigDecimal(prices[idxPrice]));

            courseService.saveCourse(course);

        }
    }

    private void GetCoursesOrderedByCountResourcesDescAndStartDateDesc(List<Course> courses) {
        courses
                .stream()
                .filter(a -> a.getResources().size() > 5)
                .sorted((a,b) -> {
                    int result = 0;
                    if(a.getResources().size()>b.getResources().size()){
                        result = -1;
                    }
                    else if (a.getResources().size()< b.getResources().size()){
                        result =  1;
                    }
                    else if(a.getResources().size() == b.getResources().size()){
                        result = b.getStartDate().compareTo(a.getStartDate());
                    }
                    return result;
                })
                .forEach(a -> {
                    System.out.println(a.getName()+" "+a.getResources().size()+" resources");
                });
    }
}
