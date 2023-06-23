import java.util.Objects;

public class TipoCombustível {
    private static int ultimoId = 0;
    private int id;
    private String nmCombustivel;

    public TipoCombustível(String nmCombustivel) {
        this.id = ultimoId + 1;
        this.nmCombustivel = nmCombustivel;
        ultimoId = this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNmCombustivel() {
        return nmCombustivel;
    }

    public void setNmCombustivel(String nmCombustivel) {
        this.nmCombustivel = nmCombustivel;
    }

    @Override
    public String toString() {
        return nmCombustivel;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCombustível that = (TipoCombustível) o;
        return Objects.equals(nmCombustivel, that.nmCombustivel);
    }

    public int hashCode() {
        return Objects.hash(nmCombustivel);
    }
}

