package com.imooc.sc.dao.Impl;

import com.imooc.sc.dao.SelectionDao;
import com.imooc.sc.entity.Selection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository("selectionDao")
public class SelectionDaoImpl implements SelectionDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void insert(List<Selection> list) {
        String sql = "insert into selection (?, ?, ?, ?)";
        List<Object[]> list1 = new ArrayList();
        for (Selection s : list) {
            Object[] arr = new Object[4];
            arr[0] = s.getStudent();
            arr[1] = s.getScore();
            arr[2] = s.getSelectionTime();
            arr[3] = s.getScore();
            list1.add(arr);
        }
        jdbcTemplate.batchUpdate(sql, list1);
    }

    public void delete(int sid, int cid) {
        String sql = "delete from selection where student = ?, course = ?";
        jdbcTemplate.update(sql, sid, cid);
    }

    public List<Map<String, Object>> selectByStudent(int sid) {
        String sql = "select sc.*, s.name, c.cname from selection sc " +
                "left join student s on sc.student = s.id " +
                "left join course c on sc.course = c.id" +
                "where sid = ?";
        return jdbcTemplate.queryForList(sql, sid);
    }

    public List<Map<String, Object>> selectByCourse(int cid) {
        String sql = "select sc.*, s.name, c.cname from selection sc " +
                "left join student s on sc.student = s.id " +
                "left join course c on sc.course = c.id" +
                "where cid = ?";
        return jdbcTemplate.queryForList(sql, cid);
    }
}
