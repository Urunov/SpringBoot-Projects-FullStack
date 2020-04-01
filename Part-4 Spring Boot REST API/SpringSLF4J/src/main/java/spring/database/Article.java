package spring.database;

/**
 * @Created 01 / 04 / 2020 - 4:22 PM
 * @project SpringJPAaudit
 * @Author Hamdamboy
 */
public class Article {
    //
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Article(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
