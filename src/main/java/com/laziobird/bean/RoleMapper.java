package com.laziobird.bean;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 *
 * @author Yunfei
 *
 */
@Mapper
public interface RoleMapper {

    @Select("select name from table_role where id in (select rid from t_user_role where uid = #{uid} )")
    String getRoleByUI(String uid);
    @Select("select * from table_role where id in (select rid from t_user_role where uid = #{uid} )")
    List<Role> getRoles(String uid);

}
