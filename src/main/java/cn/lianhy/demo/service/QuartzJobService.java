package cn.lianhy.demo.service;

import cn.lianhy.demo.form.QuartzJobFO;
import cn.lianhy.demo.to.QuartzJobTO;

import java.util.List;

public interface QuartzJobService {

    long insertBySelective(QuartzJobFO fo);

    long updateBySelective(QuartzJobFO fo);

    boolean schedulerJob(QuartzJobFO job);
}
