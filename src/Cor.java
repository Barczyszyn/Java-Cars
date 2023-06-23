import java.util.Objects;

public class Cor {
    private static int ultimoId = 0;
    private int id;
    private String nmCor;

    public Cor(String nmCor) {
        this.id = ultimoId + 1;
        this.nmCor = nmCor;
        ultimoId = this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmCor() {
        return nmCor;
    }

    public void setNmCor(String nmCor) {
        this.nmCor = nmCor;
    }

    @Override
    public String toString() {
        return nmCor;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cor that = (Cor) o;
        return Objects.equals(nmCor, that.nmCor);
    }

    public int hashCode() {
        return Objects.hash(nmCor);
    }
}
