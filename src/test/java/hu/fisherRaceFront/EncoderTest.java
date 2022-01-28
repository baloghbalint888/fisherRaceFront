package hu.fisherRaceFront;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderTest {
    @Test
    public void testEncode(){
        System.out.println(new BCryptPasswordEncoder().encode("asdfg"));
    }
}
