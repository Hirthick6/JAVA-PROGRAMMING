import java.io.Serializable;

public class StateDetails implements Serializable {
    private String capital;
    private String population;
    private String area;

    public StateDetails(String capital, String population, String area) {
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public String getCapital() {
        return capital;
    }

    public String getPopulation() {
        return population;
    }

    public String getArea() {
        return area;
    }
}
