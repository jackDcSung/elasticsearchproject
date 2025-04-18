package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Get {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //修改數據

        UpdateRequest request = new UpdateRequest();

        request.index("user").id("1001");

        request.doc(XContentType.JSON,"sex","女");

        
        UpdateResponse response = esClient.update(request, RequestOptions.DEFAULT);




        System.out.println(response.getResult());


        esClient.close();


    }


}
