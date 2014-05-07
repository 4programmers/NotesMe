package scaffold.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TestEntity  implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
