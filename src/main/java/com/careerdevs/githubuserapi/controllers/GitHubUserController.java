package com.careerdevs.githubuserapi.controllers;

import com.careerdevs.githubuserapi.models.GitHubUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/githubusers")
public class GitHubUserController {

    private static final String GH_URL = "https://api.github.com/users";

    @GetMapping("/users")
    public Object getUsers(RestTemplate restTemplate) {
        return restTemplate.getForObject(GH_URL, GitHubUser[].class);
    }

    @GetMapping("/{id}")
    public Object getAUser(RestTemplate restTemplate, @PathVariable(name = "id") String id) {
        String URL = GH_URL + "/" + id;
        return restTemplate.getForObject(URL, GitHubUser.class);
    }

    // Get data directly from GitHub
    @GetMapping("/v2/{id}")
    public Object getAUser2(RestTemplate restTemplate, @PathVariable(name = "id") String id) {
        String URL = GH_URL + "/" + id;
        return restTemplate.getForObject(URL, Object.class);
    }
}
