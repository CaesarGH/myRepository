package com.example.mapper;

import com.example.bean.BeanUser;

import java.util.List;

import org.apache.ibatis.annotations.*;



//指定这是一个操作数据库的mapper

@Mapper

public interface BeanUserMapper {



    //查询

    @Select("select * from table_one where id=#{id}")

    public BeanUser selectId(Integer id);
    
    //查询

    @Select("select * from table_one")

    public List<BeanUser> selectAll();



    //删除

    @Delete("delete from table_one where id=#{id}")

    public int deleteId(Integer id);



    //插入

    @Insert("insert into table_one(id,user_name,pass_word) values(#{id},#{user_name},#{pass_word})")

    public int insertBean(BeanUser beanUser);



    //修改

    @Update("update table_one set user_name=#{user_name},pass_word=#{pass_word} where id=#{id}")

    public int UpdateBean(BeanUser beanUser);

}