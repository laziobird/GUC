package com.laziobird.bean;

import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 *
 * @author Yunfei
 *
 *         该接口不需要类去实现它 对 User 表----查询所有的记录，插入，删除，修改，查询，
 *
 */
@Mapper
public interface UserMapper {
	@Select("select * from table_user")
	List<User> showAll();

	@Select("select u.*,r.name as roleName ,r.id as roleId ,r.describtion as roleDesc from table_user u,table_role r , t_user_role ur where u.id = ur.uid and ur.rid = r.id order by r.id desc,u.id desc")
	List<UserVo> showAllAndRole();

	@Insert("insert into table_user(name,id,password,status) values(#{name},#{id},#{password},#{status})")
	int insert(User user);

	@Insert("insert into table_user(name,id,password,status,phone,email) values(#{name},#{id},#{password},#{status},#{phone},#{email})")
	int insertAll(User user);

	@Delete("delete from table_user where id = #{id}")
	int delete(String id);

	@Update("update table_user set name = #{name} , password = #{password} where id = #{id}")
	int update(User user);

	@Update("update table_user set status = #{status}  where id = #{id}")
	int updateStatusById(User user);

	@Select("select * from table_user where id = #{id}")
	User getById(String id);

	@Select("select * from table_user where name = #{name}")
	User getByName(String name);

	@Select("select count(1) from table_user where name = #{name}")
	int countByName(String name);
}
