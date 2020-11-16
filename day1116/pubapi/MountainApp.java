package day1116.pubapi;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.net.URLEncoder;
	import java.io.BufferedReader;
	import java.io.IOException;
/*산정보조회 에서 붙여넣은 코드! 
 api키를 만들어야한다. 공공포털사이트 -> 마이페이지-> 산정보조회 -> 서비스정보->일반인증키 
 잘나오긴하지만, 식별성이 떨어지니 복사해서 이클립스 xml문서로 가져와주자! 
 */
	public class MountainApp {
	    public static void main(String[] args) throws IOException {
	    	String apikey="Hor4jre0xRCctfv98sIY%2FbbnyZeIpurWtPurIP4pNhQPuNOBgZgRLuwfY94Fu8AH4UFENMr7e8AD%2FeBi7V1UhA%3D%3D";
	    	
	    	//apikey값을 코드사이에 넣기 , 주의할 점은 아래의 StringBuilder에 적힌 주소가, 공공데이터 포털 개발자의 실수에 의해 가끔 올바르지 않을 수 있다. 
	    	//그래서 주소를 비교해 보는게 중요하다! 같아야한다.
	    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice(홈페이지)
	    	//http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice(샘플)
	    	
	    	StringBuilder urlBuilder = new StringBuilder("http://openapi.forest.go.kr/openapi/service/trailInfoService/getforeststoryservice"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "="+apikey); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("mntnNm","UTF-8") + "=" + URLEncoder.encode("지리산", "UTF-8")); /**/
	        urlBuilder.append("&" + URLEncoder.encode("mntnHght","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
	        urlBuilder.append("&" + URLEncoder.encode("mntnAdd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
	        urlBuilder.append("&" + URLEncoder.encode("mntnInfoAraCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
	        urlBuilder.append("&" + URLEncoder.encode("mntnInfoSsnCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
	        urlBuilder.append("&" + URLEncoder.encode("mntnInfoThmCd","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /**/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}

