import com.kuang.bean.Student;
import com.kuang.dao.StudentDAO;
import com.kuang.daoIMP.StudentDAOIMP;
import org.junit.Test;

import java.util.List;

public class test {

    @Test
    public void testinsert(){
        StudentDAO dao =new StudentDAOIMP();
        Student student = new Student();
        student.setID(4);
        student.setName("wangkang");
        System.out.println(student);

        dao.insert(student);
    }

    @Test
    public void testfindAll(){
        StudentDAO dao =new StudentDAOIMP();
        List<Student> students =dao.findAll();
        for (Student student : students) {
            System.out.println(student);
       }
    }
    @Test
    public  void testupdate(){
        StudentDAO dao =new StudentDAOIMP();
        Student student = dao.findByID(1);
        student.setID(1);
        student.setName("ang");
        dao.update(student);
        student = dao.findByID(1);
        System.out.println(student);
    }


    @Test
    public  void testfindByid(){
        StudentDAO dao =new StudentDAOIMP();
        Student student = dao.findByID(1);
        System.out.println(student);
    }

    @Test
    public  void testdelete(){
        StudentDAO dao =new StudentDAOIMP();
        dao.delete(1);
    }
}
