package com.atguigu.es.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Insert_Batch {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //插入數據

        IndexRequest request = new IndexRequest();

        request.index("user").id("1001");

        User user= new User();

        user.setName("zhangsan");

        user.setAge(30);

        user.setSex("boy");


        //向ES插入數據，必須將數據轉換為JSON格式
        ObjectMapper mapper = new ObjectMapper();

        String userJson = mapper.writeValueAsString(user);

        request.source(userJson, XContentType.JSON);

        //執行插入操作


        IndexResponse response = esClient.index(request, RequestOptions.DEFAULT);

        System.out.println(response.getResult());


        esClient.close();


    }


}
