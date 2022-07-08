package com.ydlclass.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TxAdvice implements MethodInterceptor {

    private PlatformTransactionManager transactionManager;

    public TxAdvice(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public PlatformTransactionManager getTransactionManager() {
        return transactionManager;
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        //默认事务配置
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        //使用事务管理器  进行事务管理
        TransactionStatus transaction = transactionManager.getTransaction(definition);

        Object invoke = null;
        try {

            invoke = invocation.getMethod().invoke(invocation.getThis(),
                    invocation.getArguments());


        } catch (RuntimeException e) {
            e.printStackTrace();
            //异常回滚
            transactionManager.rollback(transaction);
            throw new RuntimeException("遇到问题回滚！");
        }
        //提交
        transactionManager.commit(transaction);

        return invoke;
    }
}
