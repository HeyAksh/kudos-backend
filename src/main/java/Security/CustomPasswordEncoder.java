package Security;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Getter
@Component
public class CustomPasswordEncoder {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

    public String encode(String s) {
        return passwordEncoder.encode(s);
    }
}
