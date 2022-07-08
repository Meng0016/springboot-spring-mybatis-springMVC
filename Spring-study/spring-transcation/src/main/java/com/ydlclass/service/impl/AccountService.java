package com.ydlclass.service.impl;

import com.ydlclass.service.IAccountService;
import com.ydlclass.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
@Transactional
public class AccountService implements IAccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ILogService logService;

    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    public void transfer(String from,String to,Integer money) {

        //默认事务配置
        DefaultTransactionDefinition definition=new DefaultTransactionDefinition();
        //使用事务管理器  进行事务管理
        TransactionStatus transaction = transactionManager.getTransaction(definition);

        try {
            //转账是两个步骤 (语句)
            String sql="update account set money = money - ? where username =?";
            String sql2="update account set money = money + ? where username =?";
            //从转账的人处扣钱
            jdbcTemplate.update(sql,money,from);

            /* int i = 1/0;*/
            jdbcTemplate.update(sql2,money,to);
        }catch (RuntimeException e){
            e.printStackTrace();
            //异常回滚
            transactionManager.rollback(transaction);
        }
        //提交
        transactionManager.commit(transaction);



    }

    @Override
    public void transfer3(String from,String to,Integer money) {

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                //转账是两个步骤 (语句)
                String sql="update account set money = money - ? where username =?";
                String sql2="update account set money = money + ? where username =?";
                //从转账的人处扣钱
                jdbcTemplate.update(sql,money,from);

                /* int i = 1/0;*/
                jdbcTemplate.update(sql2,money,to);
            }
        });
    }



    @Override

    public void transfer2(String from,String to,Integer money) {
        //转账是两个步骤 (语句)
        String sql="update account set money = money - ? where username =?";
        String sql2="update account set money = money + ? where username =?";
        //从转账的人处扣钱
        jdbcTemplate.update(sql,money,from);
        //嵌套事务
       /*  int i = 1/0;*/
        jdbcTemplate.update(sql2,money,to);
    }
}
