package restassuredobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class User {
    private String login;
    private int id;

    @JsonProperty("public_repos")
    public int publicRepos;

    public int getPublicRepos() {
        return publicRepos;
    }

    public String getLogin() {
        return login;
    }

    public int getId() {
        return id;
    }
}
