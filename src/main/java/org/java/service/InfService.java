package org.java.service;

import java.util.List;
import java.util.Map;

public interface InfService {

    public List<Map> findAll(int page,int size);

    public int getCount();

    public void save(Map map);

    public Map findById(Integer id);

    public void update(Map map);

    public void del(Integer id);

}
