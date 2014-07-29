package y.a;

import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.TimeZone;

import org.yaml.snakeyaml.Yaml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {
    System.out.println("Hello World!");

//    Constructor constructor = new Constructor(VhostConf.class);// Car.class
//    // is root
//    TypeDescription carDescription = new TypeDescription(VhostConf.class);
//    carDescription.putMapPropertyType("queues", String.class, Queue.class);
//    constructor.addTypeDescription(carDescription);
//     Yaml yaml = new Yaml(constructor);

    Yaml yaml = new Yaml();
    Object o = yaml.load(App.class.getClassLoader().getResourceAsStream(
        "amqp.yaml"));
    
    GsonBuilder jsonBuilder = new GsonBuilder();
    jsonBuilder.registerTypeAdapter(Time.class, new TimeDeserializer());
    Reader reader = new InputStreamReader(App.class.getClassLoader().getResourceAsStream("time.json"));
    
    Gson gson = jsonBuilder.create();
    Time time = gson.fromJson(reader, Time.class);
    System.out.println(time);

  }
}

class Time {
  String hour;
  String minute;
  String second;
  TimeZone timeZone;
  
  public String toString() {
    return "[ " + hour + ", " + minute + ". " + second + "," + timeZone.getID() + "]";
  }
  
}


class TimeDeserializer implements JsonDeserializer<Time> {

  @Override
  public Time deserialize(JsonElement arg0, Type arg1,
      JsonDeserializationContext arg2) throws JsonParseException {
    
    Time time = new Time();
    if (arg0.isJsonObject()) {
      JsonObject jsonObject = arg0.getAsJsonObject();
      String hour = jsonObject.get("hour").getAsString();
      String minute = jsonObject.get("minute").getAsString();
      String second = jsonObject.get("second").getAsString();
      String timeZone = jsonObject.get("timezone").getAsString();
      
      time.hour = hour;
      time.minute = minute;
      time.second = second;
      time.timeZone = TimeZone.getTimeZone(timeZone);
      
    }
    return time;
  
  }
  
}




