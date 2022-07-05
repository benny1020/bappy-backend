package spring.bappy.controllers;

import com.google.firebase.auth.AuthErrorCode;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("idtoken : "+request.getHeader("AUTHORIZATION"));
        String idToken = request.getHeader("AUTHORIZATION");
        //request.setAttribute("userId","notRegister");
        //return true;
        //  테스트용으로 UserId에 test 넣음
        try { // success
            boolean checkRevoked  = true;
            FirebaseToken decodedToken  = FirebaseAuth.getInstance()
                    .verifyIdToken(idToken,checkRevoked);
            String uid =  decodedToken.getUid();
            request.setAttribute("userId",uid);
            //response.setHeader("token","");
            return true;
        }catch(FirebaseAuthException e) {
            if(e.getAuthErrorCode() == AuthErrorCode.REVOKED_ID_TOKEN) { // token has been revoked
                response.sendRedirect("/auth/revoke");
            }else { // token is invalid
                response.sendRedirect("/auth/invalid");
            }


        }
        //request.setAttribute("uid","1234");
        return false;


    }
}
