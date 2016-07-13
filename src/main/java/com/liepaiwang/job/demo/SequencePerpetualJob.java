package com.liepaiwang.job.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dangdang.ddframe.job.api.AbstractSequencePerpetualElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionSingleShardingContext;
@Service(value ="sequencePerpetualJob")
public class SequencePerpetualJob extends AbstractSequencePerpetualElasticJob<String>{

	@Override
	protected List<String> fetchData(JobExecutionSingleShardingContext arg0) {
		
		List<String> list = new ArrayList<>();
 		for (int i = 0; i < 1000; i++) {
 			list.add(String.valueOf(i));
		}
 		
		return list;
	}

	@Override
	protected boolean processData(JobExecutionSingleShardingContext arg0, String arg1) {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arg1);
		
		return true;
	}

}
