package com.imooc.sc.dao;

import com.imooc.sc.entity.Selection;

import java.util.List;
import java.util.Map;

public interface SelectionDao {

    // 学生选课业务不涉及到删除选课信息，因此没有delete方法

    // 学生选课，一次性肯定是插入多条数据，当然也存在选一门课时插入一条数据，因此传参用List<Selection>
    public void insert(List<Selection> list);

    // 删除学生课程时候，既要知道学生id，也要知道课程id
    public void delete(int sid, int cid);

    // 当然查询选课信息时，也不存在查询一条选课记录的业务，因此没有selectOne方法

    // 通过学生id 查询学生选课信息
    // 为什么List中用Map，而不用List<Selection>,因为用Selection的话，查询出来是有三个id，不好理解代表什么意思
    // 因此用Mao<String, Object> 便于理解,因为这样Map中存储的就是列名和对应的值
    public List<Map<String, Object>> selectByStudent(int sid);

    // 通过课程id 查询选课信息
    public List<Map<String, Object>> selectByCourse(int cid);

}
