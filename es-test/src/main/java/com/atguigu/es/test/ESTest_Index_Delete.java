package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

public class ESTest_Index_Search {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //查詢索引
        GetIndexRequest request = new GetIndexRequest("user");


        GetIndexResponse getIndexResponse =
                esClient.indices().get(request, RequestOptions.DEFAULT);


        //響應狀態
        System.out.println(getIndexResponse.getAliases());

        System.out.println(getIndexResponse.getMappings());

        System.out.println(getIndexResponse.getSettings());


        esClient.close();


    }


}
