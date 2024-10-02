//VICTOR STEWERS OLIVEIRA - ADS - MATUTINO A
package ado2;


public class Senha {
    public boolean preferencial;
    private String codigo;
    public boolean parteGrupo = false;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public boolean isPreferencial() {
        return preferencial;
    }

    public void setPreferencial(boolean preferencial) {
        this.preferencial = preferencial;
    }
    
    

    public Senha() {
    }

    public Senha(boolean preferencial, String codigo) {
        this.preferencial = preferencial;
        this.codigo = codigo;
    }
    @Override
    public String toString(){
        return this.getCodigo();
    }

    
}
