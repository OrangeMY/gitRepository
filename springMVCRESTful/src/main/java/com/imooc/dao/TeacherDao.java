package com.imooc.dao;

import com.imooc.entity.Teacher;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeacherDao {

    private Map<Integer, Teacher> map = new HashMap();

    public void insert(Teacher teacher) {
        map.put(teacher.getId(), teacher);
    }

    public void update(Teacher teacher) {
        map.put(teacher.getId(), teacher);
    }

    public void delete(int id) {
        map.remove(id);
    }

    public Teacher selectById(int id) {
        return map.get(id);
    }

    public Collection<Teacher> selectAll() {
        return map.values();
    }
}
