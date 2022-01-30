package io.hibernate.demo

import io.hibernate.config.HibernateConfig
import io.hibernate.entity.Course
import io.hibernate.entity.Review
import io.hibernate.entity.Student
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class CreateCourseAndStudentsDemo {
    static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean("sessionFactory")


        Session session = sessionFactory.getCurrentSession()

        try {

            session.beginTransaction()

            Course tempCourse = new Course("Pacman - How To Score one Million Points")

            println "Saving the course"

            session.save(tempCourse)

            println "Saved the course:  ${tempCourse}"


            Student tempStudent1 = new Student("John", "Doe", "John@gmail.com")
            Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com")

            tempCourse.addStudent(tempStudent1)
            tempCourse.addStudent(tempStudent2)

            println "Saving students ..."
            session.save(tempStudent1)
            session.save(tempStudent2)
            println "Saved students: ${tempCourse.getStudents()}"

            session.getTransaction().commit()

            println "Done"
        } finally {
            session.close()
            sessionFactory.close()
        }
        context.close()
    }
}
