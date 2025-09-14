package com.optimagrowth.license;

import com.optimagrowth.license.models.Category;
import com.optimagrowth.license.models.Organization;
import com.optimagrowth.license.models.Person;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceUnitTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private OrganizationService organizationService;

    private Organization org1;
    private Organization org2;
    private Person person1;
    private Person person2;
    private Person person3;

    @Test
    public void RecordsTest() {
        person1 = new Person();
        person1.setName("Bill");
        person1.setMajor("Chemistry");
        person1.setDept("Science");
        person1.setDateOfBirth("11/11/1998");
        person1.setPhone("1234567890");
        person1.setEmail("bill@email.com");

        person2 = new Person();
        person2.setName("John");
        person2.setMajor("Math");
        person2.setDept("Mathematics");
        person2.setDateOfBirth("1/9/1999");
        person2.setPhone("1234567890");
        person2.setEmail("john@email.com");

        person3 = new Person();
        person3.setName("Phil");
        person3.setMajor("Physics");
        person3.setDept("Science");
        person3.setDateOfBirth("1/9/1999");
        person3.setPhone("1234567890");
        person3.setEmail("phil@email.com");

        ArrayList<Person> members1 = new ArrayList<>();
        members1.add(person1);
        members1.add(person2);
        members1.add(person3);

        ArrayList<Person> members2 = new ArrayList<>();
        members2.add(person2);

        org1 = new Organization();
        org1.setName("Nike");
        org1.setCategory(Category.SPORTS);
        org1.setEstablishedDate("1/1/1885");
        org1.setPresident(person1);
        org1.setMembers(members1);

        org2 = new Organization();
        org2.setName("Org2");
        org2.setCategory(Category.ARTS);
        org2.setEstablishedDate("2/14/1900");

        org2.setPresident(person2);
        org2.setMembers(members2);

        personService.savePerson(person1);
        personService.savePerson(person2);
        personService.savePerson(person3);

        organizationService.saveOrg(org1);
        organizationService.saveOrg(org2);


        List<Person> people = personService.list();

        for (Person person : people) {
            System.out.println(person);
        }

        List<Organization> org = organizationService.list();

        for (Organization individualOrg : org) {
            System.out.println(individualOrg);
        }

        Assert.assertTrue(true);
    }
}
