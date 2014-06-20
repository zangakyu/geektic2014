package com.ninja_squad.geektic.dao;


import com.ninja_squad.dbsetup.destination.Destination;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 * Base class for DAO tests. To implement DAO tests, simply extend this class,
 * populate the database using a DbSetup (using the destination field) in a method annotated with @Before, and then
 * use the em
 * @author JB
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoTestConfig.class)
@TransactionConfiguration(defaultRollback = false)
public abstract class BaseDaoTest {

    @Autowired
    protected DataSource dataSource;

    @Autowired
    protected PlatformTransactionManager transactionManager;

    @PersistenceContext
    protected EntityManager em;

    @Autowired
    protected Destination destination;
}
