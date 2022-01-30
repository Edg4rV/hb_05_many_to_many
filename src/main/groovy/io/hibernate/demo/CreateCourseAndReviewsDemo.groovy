package io.hibernate.demo

import io.hibernate.config.HibernateConfig
import io.hibernate.entity.Course
import io.hibernate.entity.Instructor
import io.hibernate.entity.Review
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class CreateCourseAndReviewsDemo {
    static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean("sessionFactory")


        Session session = sessionFactory.getCurrentSession()

        try {

            session.beginTransaction()

            Course tempCourse = new Course("Pacman - How To Score one Million Points")

            tempCourse.addReview(new Review("Great course ... loved it!"))
            tempCourse.addReview(new Review("Cool course ... loved it!"))
            tempCourse.addReview(new Review("what a dumb course, you are an idiot!"))

            println "Saving the course"
            println tempCourse
            println tempCourse.getReviews()
            session.save(tempCourse)

            session.getTransaction().commit()

            println "Done"
        } finally {
            session.close()
            sessionFactory.close()
        }
        context.close()
    }
}
