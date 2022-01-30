package io.hibernate.demo

import io.hibernate.config.HibernateConfig
import io.hibernate.entity.Course
import io.hibernate.entity.Student
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class DeletePacmanCourseDemo {
    static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean("sessionFactory")


        Session session = sessionFactory.getCurrentSession()

        try {

            session.beginTransaction()

            int courseId = 10

            Course tempCourse = session.get(Course.class, courseId)

            println "Deleting course: ${tempCourse}"

            session.delete(tempCourse)




            session.getTransaction().commit()

            println "Done"
        } finally {
            session.close()
            sessionFactory.close()
        }
        context.close()
    }
}
