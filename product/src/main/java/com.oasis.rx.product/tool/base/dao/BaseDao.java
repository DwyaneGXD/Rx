package com.oasis.rx.product.tool.base.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 公共Dao类，封装了基本的增删改查方法
 *
 * @author 郭贤达
 * @Time 2017-6-19
 */
@Repository
public interface BaseDao<T, TExample> {

    /**
     * 根据条件查询数量
     *
     * @param example
     * @return
     */
    long getCountByExample(@Param("example") TExample example);

    /**
     * 根据ID查找单个实体
     *
     * @param id
     * @return
     */
    T findById(String id);

    /**
     * 根据条件进行查询
     *
     * @param example
     * @return
     */
    List<T> selectByExample(@Param("example") TExample example);

    /**
     * 插入单个实体
     *
     * @param record
     * @return
     */
    int insert(T record);

    /**
     * 强制插入单个实体---强制是指即使字段为null也强行进行插入
     *
     * @param record
     * @return
     */
    int insertForce(T record);

    /**
     * 批量插入
     *
     * @param records
     * @return
     */
    int insertAll(List<T> records);

    /**
     * 根据主键ID进行删除
     *
     * @param id
     * @param operator
     * @return
     */
    int deleteById(@Param("id") String id, @Param("operator") String operator);


    /**
     * 根据主键ID进行批量删除
     *
     * @param ids
     * @param operator
     * @return
     */
    int deleteByIds(@Param("list") List<String> ids, @Param("operator") String operator);


    /**
     * 根据条件进行删除
     *
     * @param example
     * @param operator
     * @return
     */
    int deleteByExample(@Param("example") TExample example, @Param("operator") String operator);

    /**
     * 根据ID更新单个实体
     *
     * @param record
     * @return
     */
    int updateById(T record);

    /**
     * 根据ID强制更新单个实体---强制是指即使字段为null也强行也强行进行更新
     *
     * @param record
     * @return
     */
    int updateForceById(T record);

    /**
     * 根据条件更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") T record, @Param("example") TExample example);

    /**
     * 根据条件强制更新---强制是指即使字段为null也强行也强行进行更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateForceByExample(@Param("record") T record, @Param("example") TExample example);

}
