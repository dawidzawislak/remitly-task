package project;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/1.json"));
        } catch (JsonMappingException e) {
            System.out.println("Couldn't map JSON file! [ " + e.getMessage() + " ]");
            System.exit(-3);
        } catch (JsonParseException e) {
            System.out.println("Couldn't parse JSON file! [ " + e.getMessage() + " ]");
            System.exit(-2);
        } catch (IOException e) {
            System.out.println("Couldn't open file! [ " + e.getMessage() + " ]");
            System.exit(-1);
        }
    }
}