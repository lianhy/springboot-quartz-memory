package cn.lianhy.demo.form;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuartzJobFO extends BaseFO{

    private Integer id;

    private String jobName;

    private String jobGroup;

    private String jobClassName;

    private String jobCronExpression;

    private String jobStatus;

    private String description;
}
