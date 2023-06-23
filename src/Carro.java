public class Carro {
    private static int ultimoId = 0;
    private int id;
    private String cor;
    private String tipoCombustível;
    private String modelo;
    private Integer potencia;

    public Carro(String cor, String tipoCombustível, String modelo, Integer potencia) {
        this.id = ultimoId + 1;
        this.cor = cor;
        this.tipoCombustível = tipoCombustível;
        this.modelo = modelo;
        this.potencia = potencia;
        ultimoId = this.id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoCombustível() {
        return tipoCombustível;
    }

    public void setTipoCombustível(String tipoCombustível) {
        this.tipoCombustível = tipoCombustível;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public void setPotencia(Integer potencia) {
        this.potencia = potencia;
    }

    public void setUltimoId(int id) {
        ultimoId = id;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", cor='" + cor + '\'' +
                ", tipoCombustível='" + tipoCombustível + '\'' +
                ", modelo='" + modelo + '\'' +
                ", potencia=" + potencia +
                '}';
    }
}
