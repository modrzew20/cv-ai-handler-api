package dm.java.it.cvaihandler.security;

import dm.java.it.cvaihandler.utils.JwtUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j(topic = "USER_SUCCESSFULLY_LOGGED")
@Component
public class OAuth2LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtils jwtUtil;

    public OAuth2LoginSuccessHandler(JwtUtils jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

        log.info("Successfully logged user: {}", oAuth2User.toString());

        String email = oAuth2User.getAttribute("email");

        Map<String, Object> claims = new HashMap<>();
        claims.put(Claims.NAME.getValue(), oAuth2User.getAttribute("name"));
        claims.put(Claims.PICTURE.getValue(), oAuth2User.getAttribute("picture"));
        claims.put(Claims.EMAIL.getValue(), email);

        String token = jwtUtil.generateToken(email, claims);

        String redirectUrl = "http://localhost:3000/login-success?token=" +
                URLEncoder.encode(token, StandardCharsets.UTF_8);
        response.sendRedirect(redirectUrl);
    }
}
