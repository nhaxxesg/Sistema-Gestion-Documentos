package app.Utilidades;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class Encoder {

    private static Argon2PasswordEncoder encoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();

    public static String passwordEncoder(String contrasena) {
        return Encoder.encoder.encode(contrasena);
    }

    public static boolean passwordMatching(String contrasenaCodificada, String contrasenaIngresada){
        return Encoder.encoder.matches(contrasenaIngresada, contrasenaCodificada);
    }

    
}
