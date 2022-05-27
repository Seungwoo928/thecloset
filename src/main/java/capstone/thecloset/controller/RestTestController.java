package capston.thecloset.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class RestTestController {

    @GetMapping("/api")
    public String callapihttp(){

        StringBuffer result = new StringBuffer();
        try{
            String urltest = "http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcsthttp://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst" +
                    "ServiceKey=bW%2F6%2F5PKEo8rhb%2BsV9kKNYDqBFCpDacCYvBYEY9fOx16N0bY2KRFGrWbmnuMqjZWe8LD62FHnBUV6Wy0nCCemw%3D%3D" +
                    "&datatype=xml"+ //요청자료형식 = xml
                    "&numOfRows=50"+ // 한페이지 결과수
                    "&pageNo=1"    + //페이지 번호 default=1
                    "&nx=60"       + // 예보지점의 X좌표 (서울특별시 종로구)
                    "&ny=127" ; // 예보지점의 y좌표 (서울특별시 종로구)
            URL url =new URL(urlstr);
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("GET");

            BufferedReader br =new BufferedReader(new InputStreamReader(urlconnection.getInputStream(),charsetName: "UTF-8"));

            String returnLine;
            result.append("<xmp>");
            while((returnLine=br.readLine()) != null) {
                result.append(returnLine + "\n");

            }
            urlconnection.disconnect();

        } catch(Exception e){
            e.printStackTrace();
        }
        return result+"</xmp>";

    }
}
