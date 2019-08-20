package com.imooc.sc.dao.Impl;

import com.imooc.sc.dao.CourseDao;
import com.imooc.sc.entity.Course;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("courseDao")
public class CourseDaoImpl implements CourseDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public void insert(Course c) {
        String sql = "insert into course(name, score) values(?, ?)";
        jdbcTemplate.update(sql, c.getName(), c.getScore());
    }

    public void update(Course c) {
        String sql = "update course set name = ?, score = ? where id = ?";
        jdbcTemplate.update(sql, c.getName(), c.getScore(), c.getId());
    }

    public void delete(int id) {
        String sql = "delete from course where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Course selectOne(int id) {
        String sql = "select * from course where id = ?";
        return (Course) jdbcTemplate.queryForObject(sql, new CourseRowMapper(), id);
    }

    public List<Course> selectAll() {
        String sql = "select * from course";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }

    private class CourseRowMapper implements RowMapper {

        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            Course c = new Course();
            c.setId(resultSet.getInt("id"));
            c.setName(resultSet.getString("name"));
            c.setScore(resultSet.getInt("score"));
            return c;
        }
    }
}
