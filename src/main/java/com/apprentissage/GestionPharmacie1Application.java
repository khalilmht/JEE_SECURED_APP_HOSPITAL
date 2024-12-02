package com.apprentissage;
import com.apprentissage.Dao.*;
import com.apprentissage.POJOs.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GestionPharmacie1Application {

	public static void main(String[] args) {
		SpringApplication.run(GestionPharmacie1Application.class, args);
	}
 //@Bean
	public CommandLineRunner start(SortiePatientDao sortiePatientDao,TraitementDao traitementDao, AdmissionDao admissionDao, PatientDao patientRepository, ConsultationDao consultationDao, MedecinDao medecinRepository)
	{
	return args -> {
		Patient p1 =new Patient("Mohammed","Youssfi",new Date(),"N'djari","6666887");
		Patient p2 =new Patient("Mohammed","Youssfi",new Date(),"N'djari","6666887");
		Patient p3 =new Patient("Mohammed","Youssfi",new Date(),"N'djari","6666887");		Medecin m1= new Medecin("khalil","yacoub",new Date(),"N'djari","999366121","generaliste");

		Patient p4 =new Patient("hissein","haroun",new Date(),"N'djari","6666887");
		Medecin m3= new Medecin("khalil","yacoub",new Date(),"N'djari","999366121","generaliste");
		Medecin m2= new Medecin("yacoub","junior",new Date(),"N'djari","000000000","cardiologue");
		Consultation c1=new Consultation(new Date(),new Time(1,2,3),"il va bien",p1,m1);
		Consultation c2=new Consultation(new Date(),new Time(2,3,4),"il va bien",p2,m3);
		Consultation c3=new Consultation(new Date(),new Time(4,5,3),"il va bien",p3,m2);
		AdmissionPatient ad1=new AdmissionPatient(new Date(),"salle 1",p1,m2);
		AdmissionPatient ad2=new AdmissionPatient(new Date(),"salle 2",p1,m1);
		AdmissionPatient ad3=new AdmissionPatient(new Date(),"salle 2",p1,m1);
		Traitement t1=new Traitement("paracetamol","500mg","20jours",p1,m2);
		Traitement t2=new Traitement("paracetamol","500mg","20jours",p1,m2);
		Traitement t3=new Traitement("paracetamol","500mg","20jours",p1,m2);
		Traitement t4=new Traitement("paracetamol","500mg","20jours",p1,m2);
		Traitement t5=new Traitement("paracetamol","500mg","20jours",p1,m2);
		SortiePatient s1=new SortiePatient(new Date(),new Time(2,2,2),p1);
		SortiePatient s2=new SortiePatient(new Date(),new Time(2,2,2),p2);
		SortiePatient s3=new SortiePatient(new Date(),new Time(2,2,2),p3);
		medecinRepository.save(m3);
		medecinRepository.save(m1);
		medecinRepository.save(m2);
		patientRepository.save(p1);
		patientRepository.save(p2);
		patientRepository.save(p3);
		patientRepository.save(p4);
		sortiePatientDao.save(s1);sortiePatientDao.save(s2);sortiePatientDao.save(s3);
traitementDao.save(t1);traitementDao.save(t2);traitementDao.save(t3);traitementDao.save(t4);traitementDao.save(t5);
	consultationDao.save(c1);consultationDao.save(c2);consultationDao.save(c3);
		admissionDao.save(ad1);admissionDao.save(ad2);admissionDao.save(ad3);
		for (Patient patient : patientRepository.findAll()) {
			System.out.println(patient.toString());
		}

		List<Medecin> medecinList=medecinRepository.findAll();
		for (Medecin medecinLists:medecinList){
			System.out.println(medecinLists.toString());
		}

		for (Consultation patient : consultationDao.findAll()) {
			System.out.println(patient.toString());
		}


	};
    }
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}

