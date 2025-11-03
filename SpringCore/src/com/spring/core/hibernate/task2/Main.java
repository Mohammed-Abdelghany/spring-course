package com.spring.core.hibernate.task2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.spring.core.hibernate.model.Doctor;
import com.spring.core.hibernate.model.DoctorDetails;
import com.spring.core.hibernate.model.Hospital;
import com.spring.core.hibernate.model.Patient;

public class Main {
    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .addAnnotatedClass(DoctorDetails.class)
                .addAnnotatedClass(Hospital.class)
                .addAnnotatedClass(Patient.class);

        SessionFactory factory = configuration.buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            Doctor doctor1 = new Doctor("moo1", 1.3);
            Doctor doctor2 = new Doctor("moo2", 11.3);
            Doctor doctor3 = new Doctor("moo3", 111.3);
            Patient patient1=new Patient("pat1","co1");
            Patient patient2=new Patient("pat2","co2");
            Patient patient3=new Patient("pat3","co3");
            DoctorDetails doctorDetails1=new DoctorDetails("D","s","d",1);
            DoctorDetails doctorDetails2=new DoctorDetails("DD","ss","dd",11);
            DoctorDetails doctorDetails3=new DoctorDetails("DDD","sss","ddd",111);
            Hospital hospital=new Hospital("hosbital",11l,13l);
            Hospital hospital2=new Hospital("hosbital2",112l,132l);

            doctor1.setDoctorDetails(doctorDetails1);
            doctor2.setDoctorDetails(doctorDetails2);
            doctor3.setDoctorDetails(doctorDetails3);
            doctor1.setHospital(hospital);
            doctor2.setHospital(hospital);
            doctor3.setHospital(hospital);
            patient1.setDoctor(doctor1);
            patient2.setDoctor(doctor1);
            patient3.setDoctor(doctor1);
            hospital.getPatients().add(patient1);
            hospital.getPatients().add(patient2);
            hospital2.getPatients().add(patient1);
            patient1.getHospitals().add(hospital);
            patient1.getHospitals().add(hospital2);
            patient2.getHospitals().add(hospital);
     
            session.save(doctor1);
            session.save(doctor2);
            session.save(doctor3);
            session.save(hospital);
            session.save(hospital2);
            session.save(patient1);
            session.save(patient2);
            session.save(patient3);
            
            session.getTransaction().commit();

            System.out.println("All saved successfully!");
        } finally {
            factory.close();
        }
    }
}
