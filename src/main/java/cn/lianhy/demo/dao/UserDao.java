package cn.lianhy.demo.dao;

public interface UserDao<TO, FO> {

    long insertBySelective(FO fo);
}
