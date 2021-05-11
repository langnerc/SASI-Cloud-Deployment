package de.thbrandenburg.nitze.webapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class WebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebAppApplication.class, args);
	}

	@PostMapping("/students")
	public String createPerson(@RequestParam(value = "firstName") String firstName) {
		Student student = new Student(firstName);
		student.setAge(25);

		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();

		session.beginTransaction();
		session.persist(student);
		session.flush();
		session.close();

		//database.save(student);

		return "Studierende(r) wurde erfolgreich in der Datenbank persistiert!";
	}

	@GetMapping("/students")
	public String viewStudents(){
		ArrayList<Student> students = new ArrayList<>(100);


		for (int i = 0; i < 100; i++) {
			Student student = new Student("Kevin");
			student.setAge(i+18);
			students.add(student);
		}
		String studentObjectMappedToJSONString = null;

		ObjectMapper om = new ObjectMapper();
		try {
			studentObjectMappedToJSONString = om.writeValueAsString(students);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}


		return studentObjectMappedToJSONString;
		
	}
}
