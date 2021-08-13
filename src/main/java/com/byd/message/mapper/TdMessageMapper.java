package com.byd.message.mapper;


import com.byd.message.domain.Message;
import com.byd.message.entity.TdMessage;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


public interface TdMessageMapper {


    List<Message> queryMessageByApplyId(String applyId);


    /**
     * 通过ID查询单条数据
     *
     * @param messageId 主键
     * @return 实例对象
     */
    TdMessage queryById(Long messageId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TdMessage> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tdMessage 实例对象
     * @return 对象列表
     */
    List<TdMessage> queryAll(TdMessage tdMessage);

    /**
     * 新增数据
     *
     * @param tdMessage 实例对象
     * @return 影响行数
     */
    int insert(TdMessage tdMessage);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TdMessage> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TdMessage> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TdMessage> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TdMessage> entities);

    /**
     * 修改数据
     *
     * @param tdMessage 实例对象
     * @return 影响行数
     */
    int update(TdMessage tdMessage);

    /**
     * 通过主键删除数据
     *
     * @param messageId 主键
     * @return 影响行数
     */
    int deleteById(String messageId);

    List<Message> queryMessageByApplyAndSender(@Param("sender") String sender, @Param("apply") String apply);
    List<Message> queryMessageByApplyAndSenderAndTime(@Param("sender") String sender
            , @Param("apply") String apply ,@Param("date") Date date);
}

