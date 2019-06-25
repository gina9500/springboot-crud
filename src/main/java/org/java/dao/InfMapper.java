package org.java.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface InfMapper {
    //加载所有显示
    public List<Map> findAll(@Param("start") int start,@Param("size") int size);
    //聚合函数
    public int getCount();
    //添加
    public void save(Map map);
    //修改时取得id
    public Map findById(Integer id);
    //修改
    public void update(Map map);
    //删除
    public void del(Integer id);
}
