package capstone.thecloset.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class RestTestApi {
    @GetMapping("/jsonapi")
    public String callApiWithJson(){
        StringBuffer result = new String(());
        String jsonPrintSting= null;
        try{
            String apiUrl = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcsthttp://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" +
                    "ServiceKey=bW%2F6%2F5PKEo8rhb%2BsV9kKNYDqBFCpDacCYvBYEY9fOx16N0bY2KRFGrWbmnuMqjZWe8LD62FHnBUV6Wy0nCCemw%3D%3D" +
                    "&datatype=json"+ //요청자료형식 = json
                    "&numOfRows=50"+ // 한페이지 결과수
                    "&pageNo=1"    + //페이지 번호 default=1
                    "&nx=60"       + // 예보지점의 X좌표 (서울특별시 종로구)
                    "&ny=127" ; // 예보지점의 y좌표 (서울특별시 종로구)

            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)  url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream,"UTF-8"));
            String returnLine;
            while((returnLine=bufferedReader.readLine()) !=null){
                result.append(returnLine);
            }
            JSONPObject jsonObject= XML.toJSONObject(result.toString());
            jsonPrintString = jsonpObject.toString();
        }
        catch (Exeception e){
            e.printStackTrace();
        }
        return jsonprintString;
    }
}
