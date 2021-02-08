package kr.carlos.test.controller;

import io.swagger.annotations.ApiOperation;
import kr.carlos.test.entity.Person;
import kr.carlos.test.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/persion")
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

//    @ApiOperation("전체 목록 조회")
//    @GetMapping
//    public Response<List<Person>> getPosts(){
//        return new Response<List<Person>>(personService.getPeople());
//    }
}
