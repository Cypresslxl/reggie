package com.itheima.reggie.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjecthandler implements MetaObjectHandler {
    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充[insert]...");
        log.info(metaObject.toString());

        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("createUser",BaseContext.getCurrentId());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }

    /**
     * 更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充[update]...");
        log.info(metaObject.toString());

        long id = Thread.currentThread().getId();
        log.info("线程id为：{}",id);

        metaObject.setValue("updateTime",LocalDateTime.now());
        metaObject.setValue("updateUser",BaseContext.getCurrentId());
    }
}
//Sure! This piece of code is a custom implementation of the `MetaObjectHandler` interface provided by MyBatis Plus. The `MetaObjectHandler` interface allows you to automatically fill in common fields of your entities (such as create time, update time, create user, update user) during database insert and update operations. This implementation is used to automatically fill these common fields when performing database operations in a Spring Boot application using MyBatis Plus.
//
//        Let's break down the code step by step:
//
//        1. `@Component`: This is a Spring stereotype annotation that marks the class as a Spring Bean. It allows the Spring framework to discover and manage this bean automatically.
//
//        2. `@Slf4j`: This is a Lombok annotation to automatically generate a logger field named `log` in the class.
//
//        3. `public class MyMetaObjecthandler implements MetaObjectHandler`: This is the custom implementation of the `MetaObjectHandler` interface.
//
//        4. `insertFill(MetaObject metaObject)`: This method is called by MyBatis Plus before performing an insert operation on an entity. It automatically fills in common fields for the entity during insertion.
//
//        - `metaObject`: This parameter represents the metadata object of the entity being inserted. It allows you to access and set the entity's field values.
//
//        In the `insertFill` method:
//
//        - The method first logs the message "公共字段自动填充[insert]..." using the logger.
//        - Then, it sets the `createTime` and `updateTime` fields to the current date and time using `LocalDateTime.now()`.
//        - It also sets the `createUser` and `updateUser` fields by calling `BaseContext.getCurrentId()` to get the current user's ID.
//
//        5. `updateFill(MetaObject metaObject)`: This method is called by MyBatis Plus before performing an update operation on an entity. It automatically fills in common fields for the entity during an update.
//
//        In the `updateFill` method:
//
//        - The method first logs the message "公共字段自动填充[update]..." using the logger.
//        - Then, it sets the `updateTime` field to the current date and time using `LocalDateTime.now()`.
//        - It also sets the `updateUser` field by calling `BaseContext.getCurrentId()` to get the current user's ID.
//
//        The `MetaObjectHandler` implementation allows you to handle common fields automatically without having to manually set them every time you perform insert or update operations on your entities. This helps to keep your codebase clean, consistent, and maintainable by centralizing the handling of common fields in a single place. The implementation also makes use of the `log` field to log useful information during the filling process, which can be helpful for debugging and monitoring.
