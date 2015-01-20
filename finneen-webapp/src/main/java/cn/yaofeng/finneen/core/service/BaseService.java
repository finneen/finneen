package cn.yaofeng.finneen.core.service;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by Finneen on 2015/1/20.
 */
public interface BaseService<T, ID extends Serializable> {
    
    T findOne(ID id);
    
    List<T> findAll();
    
    
}
