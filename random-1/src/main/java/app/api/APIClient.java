package app.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublisher;

public class APIClient<T> {
    private HttpClient httpClient;
    private String baseUrl;

    public static void main(String[] args) {
        APIClient<User> apiClient = new APIClient<User>("https://jsonplaceholder.typicode.com");
        apiClient.get("/users");
        User newUser = new User("1", "koikibabatunde14@gmail.com", "Koiki Babatunde", "bkoiki950");
        apiClient.post("/users", newUser);
    }

    public APIClient (String url) {
        this.baseUrl = url;
        httpClient = HttpClient.newHttpClient();
    }

    private HttpRequest buildRequest(String url, String method, String body) {
        BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(body.toString());
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .method(method, bodyPublisher)
            .build();

        return request;
    }

    private String makeRequest(String method, String path, String data) {
        String url = this.baseUrl + path;
        try {
            HttpRequest request;
            if (method == "GET") {
                request = buildRequest(url, "GET", "");
            } else if (method == "POST") {
                request = buildRequest(url, "POST", data);
            } else if (method == "PUT") {
                request = buildRequest(url, "PUT", data);
            } else if (method == "DELETE") {
                request = buildRequest(url, "DELETE", "");
            } else {
                System.out.println("Invalid method");
                throw new Error("Invalid method");
            }

            HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
            );
            if (response.statusCode() >= 200 && response.statusCode() < 300) {
                System.out.println(response.body());
                return response.body();
            } else {
                System.out.println("Error: " + response.statusCode());
                throw new Error("Error: " + response.statusCode());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    public String get(String path) {
        String response = this.makeRequest("GET", path, null);
        return response;
    }

    public String post(String path, T data) {
        String response = this.makeRequest("POST", path, data.toString());
        return response;
    }

    public String put(String path, T data) {
        String response = this.makeRequest("PUT", path, data.toString());
        return response;
    }

    public String delete(String path) {
        String response = this.makeRequest("DELETE", path, null);
        return response;
    }
}
