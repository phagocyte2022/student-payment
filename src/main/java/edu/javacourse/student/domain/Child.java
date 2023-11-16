package edu.javacourse.student.domain;

import javax.persistence.*;
import java.time.LocalDate;

public class Child extends Person{

    private Long childCertificateNumber;
    private LocalDate childCertificateDate;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private RegisterOffice registerOffice;

    public Long getChildCertificateNumber() {
        return childCertificateNumber;
    }

    public void setChildCertificateNumber(Long childCertificateNumber) {
        this.childCertificateNumber = childCertificateNumber;
    }

    public LocalDate getChildCertificateDate() {
        return childCertificateDate;
    }

    public void setChildCertificateDate(LocalDate childCertificateDate) {
        this.childCertificateDate = childCertificateDate;
    }

    public RegisterOffice getRegisterOffice() {
        return registerOffice;
    }

    public void setRegisterOffice(RegisterOffice registerOffice) {
        this.registerOffice = registerOffice;
    }
}
