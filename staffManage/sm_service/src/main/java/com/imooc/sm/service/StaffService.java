package com.imooc.sm.service;


import com.imooc.sm.entity.Staff;

import java.util.List;

public interface StaffService {
    void add(Staff staff);
    void remove(int id);
    void edit(Staff staff);
    Staff get(int id);
    List<Staff> getAll();
}
