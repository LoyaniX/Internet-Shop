package com.loyanix.DAO;

import com.loyanix.DAO.repo.ProductDAO;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class ProductDAOTest {

    private ProductDAO productDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public  void cleanUp
}
