package objects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Discipline {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Long selfStudyHours; //Поле может быть null

    @JsonCreator
    public Discipline(@JsonProperty("name") String name,
                      @JsonProperty("selfStudyHours") Long selfStudyHours) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        if (name.isEmpty()) {
            throw new IllegalArgumentException("name must not be empty");
        }
        this.selfStudyHours = selfStudyHours;
    }

    public String getName() {
        return name;
    }

    public Long getSelfStudyHours() {
        return selfStudyHours;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", selfStudyHours=" + selfStudyHours +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return Objects.equals(name, that.name) && Objects.equals(selfStudyHours, that.selfStudyHours);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, selfStudyHours);
    }


}
