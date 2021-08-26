package com.xy.index.impl;

import com.xy.index.IndexService;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class IndexServiceImpl implements IndexService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean createIndex(String index) {
        try {
            if (existIndex(index)){
                return true;
            }
            CreateIndexRequest request = new CreateIndexRequest(index);
            CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
            return response.isAcknowledged();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void deleteIndex(String index) {
//        if (existIndex())

    }

    @Override
    public boolean existIndex(String index) {
        GetIndexRequest request = new GetIndexRequest(index);
        boolean exists = false;
        try {
            exists = client.indices().exists(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
