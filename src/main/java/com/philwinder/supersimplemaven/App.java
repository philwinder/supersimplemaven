package com.philwinder.supersimplemaven;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;

import static org.elasticsearch.node.NodeBuilder.*;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Connecting to cluster");
        Node node = nodeBuilder()
                .clusterName("elasticsearch")
                .settings(Settings.builder().put("path.home", "/tmp/elasticsearch"))
                .node();

        System.out.println("Obtaining client");
        Client client = node.client();

        // The most basic query
        System.out.println("Performing query");
        SearchResponse response = client.prepareSearch().execute().actionGet();

        System.out.println("This is the response:");
        System.out.println(response.toString());

        client.close();
        System.out.println("Finished");
    }
}
