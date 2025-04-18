package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ESTest_Index_Create {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        CreateIndexRequest request = new CreateIndexRequest("user");


        CreateIndexResponse createIndexResponse = esClient.indices().create(request, RequestOptions.DEFAULT);


        //響應狀態
        boolean acknowledged = createIndexResponse.isAcknowledged();

        System.out.println("索引操作 ：" + acknowledged);

        


        esClient.close();


    }


}
