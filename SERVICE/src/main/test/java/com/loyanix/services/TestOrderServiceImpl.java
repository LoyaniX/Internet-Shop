package com.loyanix.services;

import com.loyanix.services.DTO.OrderDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-service-test.xml")
@Transactional
public class TestOrderServiceImpl {

    @Test
    public void testCreate(OrderDTO orderDTO){


    }
}
