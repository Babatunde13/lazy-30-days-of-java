package com.random;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


class APIClient<T> {
    private URL urlClient;
    private HttpURLConnection connection;

    private Object makeRequest(String url, String method, T data, Map<String, String> headers) {
        try {
            this.urlClient = new URL(url);
            this.connection = (HttpURLConnection) urlClient.openConnection();

            connection.setRequestMethod(method.toUpperCase());
            connection.setRequestProperty("Content-Type", "application/json");
            if (headers != null) {
                for (String key : headers.keySet()) {
                    connection.setRequestProperty(key, headers.get(key));
                }
            }

            if (data != null) {
                // Add data to request
                connection.setDoOutput(true);
                connection.getOutputStream().write(data.toString().getBytes());
            }

            connection.connect();

            if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300) {
                System.out.println(connection.getResponseCode());
            } else {
                System.out.println("Error: " + connection.getResponseCode());
                return null;
            }

            Reader inputReader = new InputStreamReader(connection.getInputStream());

            JSONParser parser = new JSONParser();
            JSONArray r;

            
            r = (JSONArray) parser.parse(inputReader);
            
            JSONObject obj = (JSONObject) r.get(0);
            System.out.println(r.get(0));
            return parser.parse(inputReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    public List<T> get(String url, Map<String, String> headers) {
        List<T> response = (List<T>) this.makeRequest(url, "get", null, headers);
        return response;

    }

    public T post(String url, T data, Map<String, String> headers) {
        return (T) this.makeRequest(url, "post", data, headers);
    }

    public T put(String url, T data, Map<String, String> headers) {
        return (T) this.makeRequest(url, "put", data, headers);
    }

    public T delete(String url, Map<String, String> headers) {
        return (T) this.makeRequest(url, "delete", null, headers);
    }
}
