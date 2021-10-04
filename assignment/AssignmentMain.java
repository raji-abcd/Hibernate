package com.techno.assignment;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.te.Hibernate.Employe;

public class AssignmentMain {
	public static void main(String[] args) throws NewInvalidException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		Query query = null;
		Student student = new Student();
		String res;

		do {
			Scanner sc = new Scanner(System.in);

			System.out.println("press 1 See all data");

			System.out.println("press 2  see any particular data");

			System.out.println("press 3 to update any particular data");

			System.out.println("press 4 delete data");
			System.out.println("enter option");
			int option = sc.nextInt();
			switch (option) {
			case 1:

				entityManagerFactory = Persistence.createEntityManagerFactory("emp");
				entityManager = entityManagerFactory.createEntityManager();
				String findAll = "from Student";
				query = entityManager.createQuery(findAll);
				List<Student> list = query.getResultList();
				System.out.println(list);
				System.out.println("..........");
				for (Student student1 : list) {
					System.out.println(student1);
				}

				break;

			case 2:
				System.out.println("see any particular data");

				entityManagerFactory = Persistence.createEntityManagerFactory("emp");
				entityManager = entityManagerFactory.createEntityManager();
				String findById = "from Student where name=:name";
				query = entityManager.createQuery(findById);
				entityManager.getProperties();
				student = (Student) query.getSingleResult();
				System.out.println(student);
				break;
			case 3:
				System.out.println(" update any particular data");
				entityManagerFactory = Persistence.createEntityManagerFactory("emp");
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String update = "update Employe set name='sumanth' where  id=500";

				query = entityManager.createQuery(update);
				int result = query.executeUpdate();

				entityTransaction.commit();

				break;
			case 4:
				entityManagerFactory = Persistence.createEntityManagerFactory("emp");
				entityManager = entityManagerFactory.createEntityManager();
				entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();

				String delete = "delete from Employe where id=200";
				query = entityManager.createQuery(delete);
				int result1 = query.executeUpdate();

				entityTransaction.commit();
			default:
				throw new NewInvalidException("invalid");

			}
			System.out.println("do you want to more " + "yes/no");
			res = sc.next();

		} while (res.equalsIgnoreCase("yes"));
	}

}
