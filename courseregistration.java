import java.util.*;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            student.registerCourse(this);
            return true;
        }
        return false;
    }

    public void displayCourseInfo() {
        System.out.println("\nCourse Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Description: " + description);
        System.out.println("Capacity: " + capacity);
        System.out.println("Schedule: " + schedule);
        System.out.println("Enrolled Students: " + enrolledStudents.size());
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void displayStudentInfo() {
        System.out.println("\nStudent ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.print("Registered Courses: ");
        for (Course course : registeredCourses) {
            System.out.print(course.getTitle() + " (" + course.getCourseCode() + "), ");
        }
        System.out.println();
    }
}

public class courseregistration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();

        // Adding sample courses
        courses.add(new Course("CS101", "Java Programming", "Intro to Java", 2, "Mon-Wed 10AM"));
        courses.add(new Course("CS102", "Data Structures", "Learn about DS", 2, "Tue-Thu 2PM"));

        while (true) {
            System.out.println("\n1. Register Student");
            System.out.println("2. Enroll in Course");
            System.out.println("3. Display Courses");
            System.out.println("4. Display Student Info");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                // Register Student
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Student Name: ");
                String name = scanner.nextLine();
                students.add(new Student(studentId, name));
                System.out.println("Student registered successfully!");
            } else if (choice == 2) {
                // Enroll in Course
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                Student student = students.stream()
                        .filter(s -> s.getStudentId() == studentId)
                        .findFirst()
                        .orElse(null);

                if (student == null) {
                    System.out.println("Student not found!");
                    continue;
                }

                System.out.println("Available Courses:");
                for (int i = 0; i < courses.size(); i++) {
                    System.out.println((i + 1) + ". " + courses.get(i).getTitle() + " (" + courses.get(i).getCourseCode() + ")");
                }

                System.out.print("Enter Course Number: ");
                int courseChoice = scanner.nextInt();

                if (courseChoice < 1 || courseChoice > courses.size()) {
                    System.out.println("Invalid course selection!");
                    continue;
                }

                Course selectedCourse = courses.get(courseChoice - 1);

                if (selectedCourse.enrollStudent(student)) {
                    System.out.println("Enrolled in " + selectedCourse.getTitle() + " successfully!");
                } else {
                    System.out.println("Course is full!");
                }
            } else if (choice == 3) {
                // Display Courses
                for (Course course : courses) {
                    course.displayCourseInfo();
                }
            } else if (choice == 4) {
                // Display Student Info
                System.out.print("Enter Student ID: ");
                int studentId = scanner.nextInt();
                Student student = students.stream()
                        .filter(s -> s.getStudentId() == studentId)
                        .findFirst()
                        .orElse(null);

                if (student != null) {
                    student.displayStudentInfo();
                } else {
                    System.out.println("Student not found!");
                }
            } else if (choice == 5) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        }
        scanner.close();
    }
}
