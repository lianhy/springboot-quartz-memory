package cn.lianhy.demo.action;

import cn.lianhy.demo.constant.JobConstant;
import cn.lianhy.demo.form.QuartzJobFO;
import cn.lianhy.demo.job.HelloJob;
import cn.lianhy.demo.service.QuartzJobService;
import cn.lianhy.demo.utils.DateUtil;
import cn.lianhy.demo.utils.IdGen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class HelloWorld {

    @Autowired
    private QuartzJobService quartzJobService;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping(value = "/addJob")
    public String addJob(){
        QuartzJobFO jobFO=new QuartzJobFO();

        String key= IdGen.getCharAndNumr(12);
        jobFO.setJobName(JobConstant.JOBKEY_USER+ key);
        jobFO.setJobGroup(JobConstant.GROUP_USER);

        jobFO.setJobClassName(HelloJob.class.getName());

        Date date=DateUtil.getInstance().addMinute(new Date(),1);
        String cronExpression=DateUtil.getInstance().getCronExpression(DateUtil.getInstance().getString(date,DateUtil.PATTERN_YMDHM));
        jobFO.setJobCronExpression(cronExpression);

        jobFO.setJobStatus("0");
        jobFO.setDescription("添加");
        jobFO.setCreateDate(DateUtil.getInstance().getNow());
        jobFO.setUpdateDate(DateUtil.getInstance().getNow());

        boolean flag=quartzJobService.schedulerJob(jobFO);
        if(!flag){
            return "error";
        }
        quartzJobService.insertBySelective(jobFO);
        return "success";
    }
}
