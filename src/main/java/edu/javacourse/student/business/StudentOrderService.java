package edu.javacourse.student.business;

import edu.javacourse.student.dao.StudentOrderRepository;
import edu.javacourse.student.domain.Person;
import edu.javacourse.student.domain.StudentOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentOrderService
{
    private static final Logger LOG = LoggerFactory.getLogger(StudentOrderService.class);

    @Autowired
    private StudentOrderRepository dao;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setHusband(buildPerson(false));
        so.setWife(buildPerson(true));
        dao.save(so);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOG.info(sos.get(0).getWife().getGivenName());
    }

    private Person buildPerson (boolean wife){
        Person p = new Person();
        p.setDateOfBirth(LocalDate.now());
        if (wife){
            p.setSurName("Doe");
            p.setGivenName("Jane");
            p.setPatronymic("Peterson");
        } else {
            p.setSurName("Doe");
            p.setGivenName("John");
            p.setPatronymic("Jamesson");
        }

        return p;
    }

}
