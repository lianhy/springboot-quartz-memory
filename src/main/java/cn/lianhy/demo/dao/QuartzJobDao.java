package cn.lianhy.demo.dao;

import java.util.List;

public interface QuartzJobDao<TO, FO> {

    long insertBySelective(FO fo);

    long updateBySelective(FO fo);
}
