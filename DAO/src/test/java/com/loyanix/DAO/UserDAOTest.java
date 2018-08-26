package com.loyanix.DAO;

import com.loyanix.DAO.model.User;
import com.loyanix.DAO.repo.UserDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/context-dao-test.xml")
@Transactional
public class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @PersistenceContext
    private EntityManager entityManager;

    @Before
    public void cleanUp(){
        entityManager.createQuery("DELETE FROM User").executeUpdate();
    }

    @Test
    public void testFindById(){

        //given
        //add user to DB
        User user = new User("Max","Loyan", 21,null);
        entityManager.persist(user);
        //when
        //get user by ID
        User actualUser = userDAO.get(user.getId());
        //then
        //what we have?
        Assert.assertEquals(user,actualUser);
    }

    @Test
    public void testDelete(){
        //given
        //add user to db
        User user = new User("Max","Loyan", 21,null);
        entityManager.persist(user);
        //when
        //delete user by id
        Long id = user.getId();
        userDAO.delete(id);
        //then
        //check user
        entityManager.clear();
        User deletedUser = entityManager.find(User.class, id);
        Assert.assertNull(deletedUser);
    }

    @Test
    public void testUpdate(){
        //given
        int age = 10;
        String name = "Max";
        String last_name = "Loyan";
        User user = new User(name,last_name,age,null);
        entityManager.persist(user);
        User newUser = new User ("Maksim", last_name,age,null);
        //when
        userDAO.update(user.getId(),newUser);
        //then
        User updateUser = entityManager.find(User.class, user.getId());
        Assert.assertEquals(user,updateUser);
    }

    @Test
    public void testCreate(){

        //given
        User user = new User("Kate", "Kulicova", 20, null);
        //when
        userDAO.create(user);
        //then
        User actualUser = entityManager.find(User.class,user.getId());
        Assert.assertEquals(user, actualUser);
    }

    @Test
    public void testFindAll(){
        //given
        // add user to db
        int age = 10;
        String name = "Kate";
        String lastname = "Kulikova";
        User user = new User(name,lastname,age,null);
        User user1 = new User(name,lastname,age,null);
        User user2 = new User(name,lastname,age,null);
        User user3 = new User(name,lastname,age,null);
        User user4 = new User(name,lastname,age,null);
        entityManager.persist(user);
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.persist(user3);
        entityManager.persist(user4);
        List<User> usersStart = Arrays.asList(user,user1,user2,user3,user4);
        //when
        //create user
        List<User> foundAll = userDAO.findAll();
        //then
        //check user id not null
        Assert.assertEquals(5,foundAll.size());
        Assert.assertTrue(usersStart.containsAll(foundAll));
    }
}
