package sg.edu.nus.iss.ssf_workshop17.model.openweather;

import java.io.Serializable;

import jakarta.json.JsonObject;

public class Conditions implements Serializable{
    private String description;
    private String icon;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public static Conditions createConditions (JsonObject o){
        Conditions condition = new Conditions();
        condition.description = "%s - %s"
            .formatted(o.getString("main"), o.getString("description"));
        condition.icon = "https://openweathermap.org/img/wn/%s@4x.png"
            .formatted(o.getString("icon"));
        return condition;

    }
}
