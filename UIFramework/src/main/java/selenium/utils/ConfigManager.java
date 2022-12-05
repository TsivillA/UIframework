package selenium.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class ConfigManager {
    private static final String PATH = "src/main/resources/config.json";

    public static String readData(String tagname, int id) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(PATH)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONObject config = (JSONObject) obj;
            Map data = (Map) config.get("data");
            Iterator<Map.Entry> dataIterator = data.entrySet().iterator();
            while (dataIterator.hasNext()) {
                Map.Entry attribute = dataIterator.next();
                if (attribute.getKey().equals(tagname)) {
                    JSONArray field = (JSONArray) attribute.getValue();
                    for (Object o:
                            field) {
                        JSONObject param = (JSONObject) o;
                        long paramId = (Long) param.get("id");
                        if (paramId == id) {
                            return param.get("name").toString();
                        }
                    }
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
