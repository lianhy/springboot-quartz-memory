package cn.lianhy.demo.job;

import cn.lianhy.demo.form.QuartzJobFO;
import cn.lianhy.demo.form.UserFO;
import cn.lianhy.demo.service.QuartzJobService;
import cn.lianhy.demo.service.UserService;
import cn.lianhy.demo.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
public class HelloJob extends QuartzJobBean{

    @Autowired
    private UserService userService;

    @Autowired
    private QuartzJobService quartzJobService;

    public HelloJob() {
        super();
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("任务执行了："+ jobExecutionContext.getJobDetail().getKey().getName());
        String name=jobExecutionContext.getJobDetail().getJobDataMap().getString("userName");
        if(StringUtils.isNotBlank(name)){
            UserFO fo=new UserFO();
            fo.setName(name);
            userService.insertBySelective(fo);

            //更改定时任务状态
            QuartzJobFO jobFO=new QuartzJobFO();
            jobFO.setJobStatus("1");
            jobFO.setJobName(jobExecutionContext.getJobDetail().getKey().getName());
            jobFO.setUpdateDate(DateUtil.getInstance().getNow());
            quartzJobService.updateBySelective(jobFO);
        }else{
            //移除定时任务
            QuartzJobFO jobFO=new QuartzJobFO();
            jobFO.setJobStatus("3");
            jobFO.setUpdateDate(DateUtil.getInstance().getNow());
            jobFO.setJobName(jobExecutionContext.getJobDetail().getKey().getName());
            quartzJobService.updateBySelective(jobFO);
        }
        log.info("任务结束了："+ jobExecutionContext.getJobDetail().getKey().getName());
    }
}
