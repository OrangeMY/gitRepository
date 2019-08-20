package com.imooc.dao;

import com.imooc.entity.TeachingPlan;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TeachingPlanDao {

    private Map<Integer, TeachingPlan> map = new HashMap();

    public void insert(TeachingPlan teachingPlan) {
        map.put(teachingPlan.getId(), teachingPlan);
    }

    public void update(TeachingPlan teachingPlan) {
        map.put(teachingPlan.getId(), teachingPlan);
    }

    public void delete(int id) {
        map.remove(id);
    }

    public TeachingPlan getById(int id) {
        return map.get(id);
    }

    public Collection<TeachingPlan> getAll() {
        return map.values();
    }
}
