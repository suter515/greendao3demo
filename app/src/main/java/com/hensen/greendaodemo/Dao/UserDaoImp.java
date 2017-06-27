package com.hensen.greendaodemo.Dao;

import com.hensen.greendaodemo.Base.BaseApplication;
import com.hensen.greendaodemo.Bean.User;
import com.hensen.greendaodemo.UserDao;

import java.util.List;

/**
 * 类注释：
 * Created by sujingtai on 2017/6/27 0027 上午 11:01
 */

public class UserDaoImp {
    /**
     * 插入
     * @param user
     */
public static void insertUser(User user){
    BaseApplication.getDaoInstant().getUserDao().insert(user);
}

    /**
     * 删除
     * @param id
     */
    public static void deleteUser(Long id){
        BaseApplication.getDaoInstant().getUserDao().deleteByKey(id);
    }

    /**
     * 更新
     * @param user
     */
    public static  void updateUser(User user){
        BaseApplication.getDaoInstant().getUserDao().update(user);
    }

    /**
     * 查询by name
     * @param name
     * @return
     */
    public static List<User> queryUser(String name){
        return  BaseApplication.getDaoInstant().getUserDao().queryBuilder().where(UserDao.Properties.Name.eq(name)).list();
    }

    /**
     * 查询所有
     * @return
     */
    public static List<User>queryAll(){
        return BaseApplication.getDaoInstant().getUserDao().loadAll();
    }
}
