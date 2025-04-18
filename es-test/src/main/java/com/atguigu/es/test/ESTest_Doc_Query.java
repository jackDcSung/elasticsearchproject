package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class ESTest_Doc_Query {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //查詢數據

        GetRequest request = new GetRequest();

        request.index("user").id("1001");


        GetResponse response = esClient.get(request, RequestOptions.DEFAULT);

        System.out.println(response.getSourceAsString());


        esClient.close();


    }


}
