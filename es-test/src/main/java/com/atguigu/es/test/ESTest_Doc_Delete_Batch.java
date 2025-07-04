package com.atguigu.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTest_Doc_Delete_Batch {

    public static void main(String[] args) throws IOException {
        //創建ES客戶端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        //批量_插入數據
        BulkRequest request = new BulkRequest();


        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON , "name", "zhangsanupdate"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON , "name", "lisi"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON , "name", "wangwu"));


        BulkResponse response = esClient.bulk(request, RequestOptions.DEFAULT);


        System.out.println(response.getTook());
        System.out.println(response.getItems());

        esClient.close();


    }


}
