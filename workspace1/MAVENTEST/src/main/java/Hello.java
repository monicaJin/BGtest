
import org.json.JSONObject;

public class Hello {

	public static void letstry() {
		String text = "text";
//		if (text.length()>0) {
//			System.out.print("here");
//		}

		if (text == null) {
			System.out.print("here");
		}

		System.out.print("here2");
	}

	public static void jsontest() {
		String result = "{\"success\":true,\"message\":\"登录成功\",\"code\":200,\"result\":{\"redirectUri\":\"http://192.168.51.30/cigpf-gw/cigpf-auth/oauth/authorize?client_id=SampleClientId&response_type=code&client_secret=secret&redirect_uri=http://192.168.51.30/datavisual\"},\"timestamp\":1713924134681}";

		JSONObject responseJson = new JSONObject(result);;
		String redirect_uri=responseJson.getJSONObject("result").getString("redirectUri");
		System.out.println(redirect_uri);
		Integer code=(Integer) responseJson.get("code");
		
		if (code.intValue()==200) {
			System.out.println("ok");
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello.jsontest();

	}

}
