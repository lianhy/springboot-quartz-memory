package cn.lianhy.demo.service.impl;

import cn.lianhy.demo.constant.JobConstant;
import cn.lianhy.demo.dao.QuartzJobDao;
import cn.lianhy.demo.form.QuartzJobFO;
import cn.lianhy.demo.service.QuartzJobService;
import cn.lianhy.demo.to.QuartzJobTO;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Slf4j
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

    @Autowired
    private Scheduler scheduler;

    @Resource
    private QuartzJobDao<QuartzJobTO,QuartzJobFO> quartzJobDao;

    @Override
    @Transactional
    public long insertBySelective(QuartzJobFO fo) {
        return quartzJobDao.insertBySelective(fo);
    }

    @Override
    @Transactional
    public long updateBySelective(QuartzJobFO fo) {
        return quartzJobDao.updateBySelective(fo);
    }

    @Override
    public boolean schedulerJob(QuartzJobFO job) {
        boolean flag=true;
        try{
            Class cls = Class.forName(job.getJobClassName()) ;
            //job实例
            JobDetail jobDetail= JobBuilder.newJob(cls)
                    .withIdentity(job.getJobName(), job.getJobGroup())
                    .usingJobData("userName",job.getJobName())
                    .build();
            //触发器
            Trigger trigger= TriggerBuilder.newTrigger()
                    .withIdentity(JobConstant.TRIGGER+job.getJobName(),job.getJobGroup())
                    .withSchedule(CronScheduleBuilder.cronSchedule(job.getJobCronExpression()))
                    .build();
            //调度器
            scheduler.scheduleJob(jobDetail,trigger);
        }catch (Exception e){
            log.error("/addJob 异常："+e);
            flag=false;
        }
        return flag;
    }
}
