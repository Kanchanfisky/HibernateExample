import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {


    public static void main(String args[])

    {

//        Book book = new Book();
//        book.setTitle("Computer Programming");
//        book.setAuthor("Ramanayak");
//        book.setPrice(20.45f);

        Laptop laptop = new Laptop();
        laptop.setLname("MacBook");


        Student student = new Student();
        student.setName("Mark");
        student.setMarks(45);

        student.setLaptop(laptop);

        Configuration con = new Configuration().configure().addAnnotatedClass(Book.class).addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);

        //SessionFactory is an interface
        SessionFactory sf = con.buildSessionFactory();

        //Session is interface
        Session session = sf.openSession();

        Transaction tx = session.beginTransaction();

//        for ( int i = 0; i < 15; i++){
//
//            Book book = new Book();
//            book.setTitle("Book" + i);
//            book.setAuthor("Author" + i);
//            book.setPrice(20.45f + i);
//
//            session.save(book);
//
//        }

        session.save(laptop);
        session.save(student);

        session.getTransaction().commit();

    }
}
