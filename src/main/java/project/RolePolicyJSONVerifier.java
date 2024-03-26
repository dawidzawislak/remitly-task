package project;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RolePolicyJSONVerifier {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    public static boolean checkRolePolicyJSONFile(String fileName) throws java.io.IOException, com.fasterxml.jackson.core.JsonParseException, com.fasterxml.jackson.databind.JsonMappingException {
        String json = new String(Files.readAllBytes(Paths.get(fileName)));

        return checkRolePolicyJSON(json);
    }

    public static boolean checkRolePolicyJSON(String json) throws IOException, JsonParseException, JsonMappingException {
        RolePolicy rolePolicy = objectMapper.readValue(json, RolePolicy.class);

        if (rolePolicy.policyName == null || rolePolicy.policyDocument.version == null || rolePolicy.policyDocument.statement == null)
            throw new JsonMappingException("JSON doesn't include required fields!");

        for (Statement statement : rolePolicy.policyDocument.statement) {
            if (statement.action == null || statement.resource == null)
                throw new JsonMappingException("JSON doesn't include required fields!");

            if (statement.resource.equals("*")) return false;
        }
        return true;
    }
}
