package com.imooc.sm.dao;

import com.imooc.sm.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffDao {
    void insert(Staff staff);
    void delete(int id);
    void update(Staff staff);
    Staff selectById(int id);
    List<Staff> selectAll();
}
