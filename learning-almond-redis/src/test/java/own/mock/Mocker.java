package own.mock;

import java.io.Serializable;

/**
 * Created by 伟君子 on 2018/3/15.
 */
public class Mocker implements Serializable {
    private int id;
    private String name;

    public Mocker(int id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
