package com.random;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        APIClient<User> apiClient = new APIClient<User>();
        List<User> users = apiClient.get("https://jsonplaceholder.typicode.com/users", null);
        System.out.println(users.get(0));
        User u = apiClient.post("https://jsonplaceholder.typicode.com/users", new User("test", "test", "test", "test", "test"), null);
        System.out.println(u);

    }
}
