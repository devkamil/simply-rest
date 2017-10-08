package pl.devkamil.app;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RestContent {
    @JsonProperty("id") String id;
    @JsonProperty("login") String login;
    @JsonProperty("name") String name;
    @JsonProperty("type") String type;
    @JsonProperty("avatar_url") String avatarUrl;
    @JsonProperty("created_at") String createdAt;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}