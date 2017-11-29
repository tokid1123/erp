package com.tokid.base.service;
/*
* @Description: TODO
* @author king
* @date 2017/11/22 16:56
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tokid.base.mapper.BaseMapper;
import com.tokid.base.utils.PageForm;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseService<T, M> {

    @Autowired
    private BaseMapper<T> mapper;

    /**
     * 根据 id 查询 model
     * @param id
     * @return
     */
    public T selectById(M id){
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param record
     * @return
     */
    public List<T> select(T record){
        return mapper.select(record);
    }

    /**
     * 查询全部结果
     * @return
     */
    public List<T> selectAll(){
        return this.select(null);
    }

    /**
     * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
     * @param record
     * @return
     */
    public T selectOne(T record){
        return mapper.selectOne(record);
    }

    /**
     * 根据实体中的属性查询总数，查询条件使用等号
     * @param record
     * @return
     */
    public int selectCount(T record){
        return mapper.selectCount(record);
    }

    /**
     * 保存一个实体，null的属性也会保存，不会使用数据库默认值
     * @param record
     * @return
     */
    public Long insert(T record){
        return Long.valueOf(mapper.insert(record));
    }

    /**
     * 保存一个列表
     * spring boot 不支持通用mapper的insertList接口,这里只做小批量的插入,大批量的插入请自行写sql
     * @param list
     * @return
     */
    public int insertList(List<T> list){
        int count = 0;
        for(T t:list){
            count += mapper.insert(t);
        }
        //return mapper.insertList(list);
        return count;
    }

    /**
     * 根据主键更新实体全部字段，null值会被更新
     * @param record
     * @return
     */
    public Long  updateAllById(T record){
        return Long.valueOf(mapper.updateByPrimaryKey(record));
    }

    /**
     * 根据主键更新属性不为null的值
     * @param record
     * @return
     */
    public Long update(T record){
        return Long.valueOf(mapper.updateByPrimaryKeySelective(record));
    }

    /**
     * 删除 支持批量
     * @param args
     * @return
     */
    public int deletes(M... args){
        //return system.delete(args);
        int count = 0;
        for(M m : args)
            count += mapper.deleteByPrimaryKey(m);
        return count;
    }

    public int deleteObjs(T... args){
        //return system.delete(args);
        int count = 0;
        for(T t : args)
            count += mapper.delete(t);
        return count;
    }

    /**
     * 返回datables数据结果
     * @param pageForm
     */
    public PageForm selectPage(PageForm pageForm, T record){

        //启动分页后，再操作数据库，查不到数据
        List<T> list = this.select(record);
        PageHelper.startPage(pageForm.getStart(), pageForm.getLength());
        PageInfo<T> page = new PageInfo<>(list);
        pageForm.setRecordsTotal(page.getTotal());
        pageForm.setRecordsFiltered(page.getTotal());
        pageForm.setData( page.getList());
        return pageForm;
    }

}
