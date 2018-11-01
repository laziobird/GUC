package com.laziobird.bean;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 
 * @author laziobird
 *
 */
@Mapper
public interface PermissionMapper {

    //获取用户权限
    @Select("SELECT * from table_per WHERE id in (SELECT pid FROM t_role_per where rid in (SELECT rid from t_user_role WHERE uid = #{uid}))")
    public List<Permission> getPerListByUid(String uid);
    //按排序获取所有权限
    @Select("select * from table_per where status = 1 order by pid,sort")
    List<Permission> getPerListAll();  
    //添加权限
    @Insert("insert into table_per(name,url,pid,sort) values(#{name},#{url},#{pid},#{sort})")
    int insert(Permission permission);    
    //pid获取子权限
    @Select("SELECT * from table_per WHERE pid = #{pid}")
    public List<Permission> getPerListByPid(String pid);    
}
