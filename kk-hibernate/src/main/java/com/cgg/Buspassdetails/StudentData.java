package com.cgg.Buspassdetails;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentData {

  public static void main(String[] args) {
    try (
      Session session = new Configuration()
        .configure()
        .buildSessionFactory()
        .openSession()
    ) {
      Transaction transaction = session.beginTransaction();
      for (int i = 1; i <= 20; i++) {
        Center center = generateCenterEntity(i);
        session.persist(center);

        PassDetails passDetails = insertdata(i, center);
        session.persist(passDetails);

        if (i % 5 == 0) {
          session.flush();
          session.clear();
        }
      }
      transaction.commit();
    }
  }

  private static PassDetails insertdata(int index, Center center) {
    PassDetails passDetails = new PassDetails();
    passDetails.setBpApplId("BP" + index);
    passDetails.setInstDistId(1); // Sample instDistId
    passDetails.setInstMandalId(2); // Sample instMandalId
    passDetails.setInstUnivId("Univ" + index);
    passDetails.setInstId("Inst" + index);
    passDetails.setStudentCourseId("Course" + index);
    passDetails.setPresentCourseYear("Year" + index);
    passDetails.setStudentAdmissionNo("AdmissionNo" + index);
    passDetails.setJrnyFromPlace("FromPlace" + index);
    passDetails.setJrnyToPlace("ToPlace" + index);
    passDetails.setJrnyVia("Via" + index);
    passDetails.setStudentResAddress("ResAddress" + index);
    passDetails.setStudentResAddDistId(3); // Sample studentResAddDistId
    passDetails.setStudentResAddMandalId(4); // Sample studentResAddMandalId
    passDetails.setStudentResAddVillageId(5); // Sample studentResAddVillageId
    passDetails.setStudentCellNo(123456789012345L + index); // Sample studentCellNo
    passDetails.setStudentQualification("Qualification" + index);
    passDetails.setStudentName("Name" + index);
    passDetails.setStudentFname("FatherName" + index);
    passDetails.setStudentDob(new Date()); // Sample studentDateOfBirth
    passDetails.setStudentSscHtno(987654321012345L + index); // Sample studentSSCHallTicketNumber
    passDetails.setStudentSscBoard("SSCBoard" + index);
    passDetails.setStudentSscPassyear(2022L + index); // Sample studentSSCPassYear
    passDetails.setStudentSscPasstype("SSCPassType" + index);
    passDetails.setStudentGender('M'); // Sample studentGender
    passDetails.setStudentAadharno("AadharNo" + index);

    // Set the Center entity separately
    passDetails.setCenterId(center);

    return passDetails;
  }

  private static Center generateCenterEntity(int index) {
    Center center = new Center();
    center.setDate(new Date());
    center.setCapacity(100 + index);
    center.setRegisteredStudents(50 + index);
    center.setStatus("Active");
    center.setInsertedTime(new Date());
    center.setPassId(1000 + index);
    center.setMapId(2000 + index);
    center.setPassDetails(generatePassDetailsList(center, index));
    return center;
  }

  private static List<PassDetails> generatePassDetailsList(
    Center center,
    int index
  ) {
    List<PassDetails> passDetailsList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      PassDetails passDetails = new PassDetails();
      // Set values for PassDetails fields based on your requirement
      passDetails.setCenterId(center);
      passDetailsList.add(passDetails);
    }
    return passDetailsList;
  }
}
