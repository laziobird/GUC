package com.laziobird.bean;

import org.apache.ibatis.annotations.*;

import java.util.List;
/**
 * 
 * @author laziobird
 *
 */
@Mapper
public interface AppMapper {
	
    @Select("select * from table_app")
    List<App> showAll();

    @Insert("insert into table_app(name,url,status,info) values(#{name},#{url},#{status},#{info})")
    int insert(App app);    

    @Update("update table_app set name = #{name},info = #{info},url = #{url} where id = #{id}")
    int update(App app);
    
    @Update("update table_app set status = #{status}  where id = #{id}")
    int updateStatusById(App app);  
    
    @Select("select * from table_app where id = #{id}")
    App getById(String id);
    
    @Select("select * from table_app where name = #{name}")
    User getByName(String name);    
    
    @Select("select count(1) from table_app where name = #{name}")
    int countByName(String name);      
    
}
