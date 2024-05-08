package restassuredobjects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserRecord(
        String login,
        int id,
        @JsonProperty("public_repos")
        int publicRepos
) {

}
