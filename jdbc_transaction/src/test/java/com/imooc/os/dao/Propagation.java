package com.imooc.os.dao;

public class Propagation {
    // 当有两个方法，一个a方法，一个b方法，若两个方法都属于各自的事务中，当a事务中调用了b方法，
    // 同时b方法也属于一个事务，那么这时候就要看事务的传播行为，来决定了，具体如下：
    // PROPAGATION_REQUIRED 支持当前事务，如果当前没有事务就新建一个事务。这个最常用
    //      意思是：如下面的例子，如果a方法是一个事务，且a事务中调用了b方法，那么b方法就会加入a事务当中，
    //  如果当前a方法中没有事务，那么b自己会创建一个事务，自己就是一个事务
    // 同理还有很多其他的事务传播行为，就不一一列举
    public void a() {
        // begin
        // 步骤
        b();
        // commit
    }

    public void b() {
        // begin
        // 步骤
        // commit
    }
}
