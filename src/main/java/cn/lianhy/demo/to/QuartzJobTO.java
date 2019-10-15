package cn.lianhy.demo.to;

import cn.lianhy.demo.form.BaseFO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartzJobTO extends BaseFO{

    private Integer id;

    private String jobName;

    private String jobGroup;

    private String jobClassName;

    private String jobCronExpression;

    private String jobStatus;

    private String description;
}
