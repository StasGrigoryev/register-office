package com.home.register.view;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class MarriageRequest {
    private String husbandFirstname;
    private String husbandLastname;
    private String husbandPatronymic;
    private LocalDate husbandDateOfBirth;
    private String husbandPassportSeries;
    private String husbandPassportNumber;
    private LocalDate husbandPassportIssueDate;
    private String wifeFirstname;
    private String wifeLastname;
    private String wifePatronymic;
    private LocalDate wifeDateOfBirth;
    private String wifePassportSeries;
    private String wifePassportNumber;
    private LocalDate wifePassportIssueDate;

    private String marriageCertificateNumber;
    private String marriageCertificateDate;
}
