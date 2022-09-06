package spring.bappy.config;

import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import spring.bappy.BappyApplication;


import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void init(){
        try{
            //FileInputStream serviceAccount =
            //        new FileInputStream("src/main/resources/firebase.json");
            // file byte 읽기
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("firebase.json");
// byte에서 char 변형
            //InputStreamReader reader = new InputStreamReader(in);
// char에서 string 변형
            //BufferedReader buff = new BufferedReader(reader);
            //InputStream resourceURL = this.getClass().getResourceAsStream("/firebase.json");
            //System.out.println(buff.toString());
            //FileInputStream serviceAccount =
            //        new FileInputStream(String.valueOf(buff));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(in))
                    .build();
            FirebaseApp.initializeApp(options);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
