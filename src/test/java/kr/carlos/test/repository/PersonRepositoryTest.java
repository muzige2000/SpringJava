package kr.carlos.test.repository;

import junit.framework.TestCase;
import kr.carlos.test.entity.Person;
import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonRepositoryTest extends TestCase {
    @Autowired
    PersonRepository personRepository;

    @Test
    public void insertTest() {
        Person person = Person.builder()
                .age(30)
                .name("test")
                .build();
        personRepository.save(person);

        Person findPerson = personRepository.findByName(person.getName());

        assertThat(person.getId(), equalTo(findPerson.getId()));
        assertThat(person.getAge(), equalTo(findPerson.getAge()));
        assertThat(person.getName(), equalTo(findPerson.getName()));

        personRepository.deleteAll();
    }


    void insertFindAllTestData(int size){
        Random random = new Random();
        for (int i = 0; i < size; ++i){
            Person person = Person.builder()
                    .age(random.nextInt(100))
                    .name(RandomString.make(20))
                    .build();
            personRepository.save(person);
        }
    }
}
