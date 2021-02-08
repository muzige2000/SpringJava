package kr.carlos.test;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/applicationContext.xml"})
@Transactional
@Rollback(value=false)
public class PetTest {

//    @Autowired
//    MongoTemplate mongoTemplate;

    @Test
    public void insertTest(){
//        Pet pet = Pet.builder()
//                .kind("CAT")
//                .name("나비")
//                .age(2)
//                .build();
//        mongoTemplate.insert(pet);
//
//
//        Criteria criteria = new Criteria("name");
//        criteria.is("나비");
//        Query query = new Query(criteria);
//
//        Pet findPet = mongoTemplate.findOne(query, Pet.class, "pets");
//
//        System.out.println(findPet);
//        assertThat(pet.getId(), equalTo(findPet.getId()));


    }
}
