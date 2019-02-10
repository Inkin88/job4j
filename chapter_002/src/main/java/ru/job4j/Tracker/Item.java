package ru.job4j.tracker;

public class Item {
    private String name;
    private String desc;
    private long created;
    private String[] comments;
    private String id;
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public String getName() {
        return this.name;
    }
    public String getDesc(String desc) {
        return this.desc;
    }
    public String getId() {

        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public long getCreated() {
        return this.created;
    }
    public String[] getComments(String[] args) {
        return this.comments;
    }
}