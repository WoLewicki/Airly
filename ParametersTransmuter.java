import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

public class ParametersTransmuter {

    ParametersParser output = new ParametersParser(50.06, 20.0,1);
    String outputList = output.getParameteres();
    JsonParser jsonParser = new JsonParser();
    JsonObject jo = (JsonObject)jsonParser.parse(outputList);
    JsonPrimitive jsonObject = jo.getAsJsonPrimitive("airQualityIndex");
    String partOfJsonString = new Gson().fromJson(jsonObject, String.class);

}
