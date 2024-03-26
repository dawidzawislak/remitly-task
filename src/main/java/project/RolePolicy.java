package project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RolePolicy {
    @JsonProperty("PolicyName")
    public String policyName;
    @JsonProperty("PolicyDocument")
    public PolicyDocument policyDocument;
}
