package edu.javacourse.student.business;

import edu.javacourse.student.dao.StreetRepository;
import edu.javacourse.student.dao.StudentOrderRepository;
import edu.javacourse.student.domain.*;
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
    @Autowired
    private StreetRepository daoStreet;

    @Transactional
    public void testSave() {
        StudentOrder so = new StudentOrder();
        so.setHusband(buildAdult(false));
        so.setWife(buildAdult(true));
        dao.save(so);
    }

    @Transactional
    public void testGet() {
        List<StudentOrder> sos = dao.findAll();
        LOG.info(sos.get(0).getWife().getGivenName());
    }

    private Adult buildAdult (boolean wife){
        Adult p = new Adult();
        p.setDateOfBirth(LocalDate.now());
        Address a = new Address();
        a.setPostCode("NW16XE");
        a.setBuilding("221");
        a.setExtension("b");
        a.setApartment("11");
        p.setAddress(a);
        Street one = daoStreet.getOne(1L);
        a.setStreet(one);

        if (wife){
            p.setSurName("Doe");
            p.setGivenName("Jane");
            p.setPatronymic("Peterson");
            p.setPassportSeria("WIFE-S");
            p.setPassportNumber("WIFE-N");
            p.setIssueDate(LocalDate.now());
        } else {
            p.setSurName("Doe");
            p.setGivenName("John");
            p.setPatronymic("Jamesson");
            p.setPassportSeria("HUSBAND-S");
            p.setPassportNumber("HUSBAND-N");
            p.setIssueDate(LocalDate.now());
        }

        return p;
    }

}
