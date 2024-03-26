package project;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RolePolicyJSONVerifierTest {
    @Test
    void shouldThrowIOExceptionForNonExistingFile() {
        assertThrows(IOException.class, ()->{RolePolicyJSONVerifier.checkRolePolicyJSONFile("nonexistingfile.json");});
    }

    @Test
    void shouldThrowJsonMappingExceptionForEmptyFile() {
        assertThrows(JsonMappingException.class, ()->{RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/empty.json");});
    }

    @Test
    void shouldThrowJsonMappingExceptionForEmptyObjectJSON() {
        assertThrows(JsonMappingException.class, ()->{RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/empty_object.json");});
    }

    @Test
    void shouldThrowJsonMappingExceptionForJSONWithBadStructure() {
        assertThrows(JsonMappingException.class, ()->{RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/bad_structure.json");});
    }

    @Test
    void shouldThrowJsonParseExceptionForInvalidJSON() {
        assertThrows(JsonParseException.class, ()->{RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/invalid_json.json");});
    }

    @Test
    void shouldReturnFalseForSimpleJSON() {
        assertDoesNotThrow(() -> {
            assertFalse(RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/1.json"));
        });
    }

    @Test
    void shouldReturnFalseForMultipleStatementsJSONIfAtLeastOneResourceIsAsterisk() {
        assertDoesNotThrow(() -> {
            assertFalse(RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/2.json"));
        });
    }

    @Test
    void shouldReturnTrueForSimpleJSON() {
        assertDoesNotThrow(() -> {
            assertTrue(RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/3.json"));
        });
    }

    @Test
    void shouldReturnFalseForMultipleStatementsJSONIfNoneResourceIsAsterisk() {
        assertDoesNotThrow(() -> {
            assertTrue(RolePolicyJSONVerifier.checkRolePolicyJSONFile("src/test/resources/4.json"));
        });
    }
}