package org.java.service.Impl;

import org.java.dao.InfMapper;
import org.java.service.InfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class InfServiceImpl implements InfService {

    @Autowired
    private InfMapper infMapper;

    @Override
    public int getCount() {
        return infMapper.getCount();
    }

    @Override
    public List<Map> findAll(int page,int size) {
        //计算下标
        int start=(page-1)*size;
        List<Map> list=infMapper.findAll(start,size);
        return list;
    }

    @Transactional
    public void save(Map map){
        infMapper.save(map);
    }

    @Override
    public Map findById(Integer id) {
        Map map = infMapper.findById(id);
        return map;
    }

    @Transactional
    @Override
    public void update(Map map) {
        infMapper.update(map);
    }

    @Transactional
    public void del(Integer id){
        infMapper.del(id);
    }
}
