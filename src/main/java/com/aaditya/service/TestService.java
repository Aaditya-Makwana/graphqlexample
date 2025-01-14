package com.aaditya.service;

import com.aaditya.model.Test;
import com.aaditya.repository.TestRepository;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@GraphQLApi
public class TestService {

    @Autowired
    private TestRepository testRepository;

    @GraphQLQuery(name = "getalltest")
    public List<Test> getAllTest(){
        return testRepository.findAll();
    }

    @GraphQLMutation(name = "addTest")
    public Test addTest(@GraphQLArgument(name = "id") Integer id, @GraphQLArgument(name = "desc") String desc){
        Test test = new Test(id, desc);
        testRepository.save(test);
        return test;
    }
}
