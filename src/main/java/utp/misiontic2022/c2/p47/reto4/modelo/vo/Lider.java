package utp.misiontic2022.c2.p47.reto4.modelo.vo;

public class Lider {
    private String nombre;
    private String primerApellido;
    private String segundoApellido; 
    private int salario;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }
}
