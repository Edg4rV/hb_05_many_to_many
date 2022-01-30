package io.hibernate.demo

import io.hibernate.config.HibernateConfig
import io.hibernate.entity.Course
import io.hibernate.entity.Student
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AddCourseForMaryDemo {
    static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean("sessionFactory")


        Session session = sessionFactory.getCurrentSession()

        try {

            session.beginTransaction()

            int studentId = 2
            Student tempStudent = session.get(Student.class, studentId)

            println "\nLoaded student: ${tempStudent}"
            println "Courses: ${tempStudent.getCourses()}"

            Course tempCourse1 = new Course("Rubik's Cube -How to Speed Cube")
            Course tempCourse2 = new Course("Atari 2600 - Game Development")

            tempCourse1.addStudent(tempStudent)
            tempCourse2.addStudent(tempStudent)

            println "\nSaving the courses ..."

            session.save(tempCourse1)
            session.save(tempCourse2)

            session.getTransaction().commit()

            println "Done"
        } finally {
            session.close()
            sessionFactory.close()
        }
        context.close()
    }
}
