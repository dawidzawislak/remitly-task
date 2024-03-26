package project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statement {
    @JsonProperty("Sid")
    public String sid;
    @JsonProperty("Effect")
    public String effect;
    @JsonProperty("Action")
    public Object action;
    @JsonProperty("Resource")
    public Object resource;
    @JsonProperty("Condition")
    public Object condition;
}
