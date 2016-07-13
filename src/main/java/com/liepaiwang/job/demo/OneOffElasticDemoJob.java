package com.liepaiwang.job.demo;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
@Service(value="oneOffElasticJob")
public class OneOffElasticDemoJob extends AbstractOneOffElasticJob {

	@Override
	protected void process(JobExecutionMultipleShardingContext arg0) {
		
		System.out.println(arg0.getShardingItems());
		
		System.out.println(JSON.toJSONString(arg0));
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + " hello world");
		
	}
}
