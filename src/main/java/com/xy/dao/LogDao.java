package com.xy.dao;

import com.xy.model.LogModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface LogDao extends ElasticsearchRepository<LogModel,String> {

}
