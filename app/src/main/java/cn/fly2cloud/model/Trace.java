package cn.fly2cloud.model;

/**
 * Created by Administrator on 2018/4/14.
 */

public class Trace {
    private String Time;
    private String Name;
    private String imageAdd;
    private String Descri;

    public String getImageAdd() {
        return imageAdd;
    }

    public void setImageAdd(String imageAdd) {
        this.imageAdd = imageAdd;
    }

    public String getDescri() {
        return Descri;
    }

    public void setDescri(String descri) {
        Descri = descri;
    }

    public Trace(){}

    public Trace(String time, String name) {
        this.Time = time;
        this.Name = name;
    }

    public Trace(String time, String name, String imageAdd, String descri) {
        this.Time = time;
        this.Name = name;
        this.imageAdd = imageAdd;
        this.Descri = descri;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        this.Time = time;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
}
