import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class ParametersParser {

    private String ApiKey;
    private double latitude;
    private double longitude;
    private int sensorID;

    public ParametersParser(String ApiKey, double latitude, double longitude, int sensorID) {
        this.ApiKey = ApiKey;
        this.latitude = latitude;
        this.longitude = longitude;
        this.sensorID = sensorID;
    }

    public ParametersParser(double latitude, double longitude, int sensorID) {
        this.ApiKey = "4c2b5e0666f446f8b282bc2b18b8e7ea";
        this.latitude = latitude;
        this.longitude = longitude;
        this.sensorID = sensorID;
    }

    public String getParameteres ()
    {
        try {

            String url = String.format(Locale.US,"https://airapi.airly.eu/v1/nearestSensor/measurements?latitude=%.2f&longitude=%.2f&maxDistance=1000 ", this.latitude, this.longitude);
            URL obj = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setRequestMethod("GET");

            conn.setRequestProperty ("apikey", this.ApiKey);


            BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer buffer = new StringBuffer();
            String line;
            while((line = input.readLine()) != null) {
                buffer.append(line);
            }
            input.close();

            return buffer.toString();

        } catch (Exception e) {
          return  e.toString();
        }
    }
}