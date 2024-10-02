//VICTOR STEWERS OLIVEIRA - ADS - MATUTINO A
package ado2;
 
public class Fila {
 
    public Senha[] senhas;
    public int tamanho;
    public int tamanhoEstrutura;
    public int qntSenhaPref;
    public int qntSenhaComum;
 
    public Fila(int capacidade) {
        this.senhas = new Senha[capacidade];
        this.tamanho = 0;
    }
 
    public Fila() {
        this(10);
    }
 
    public String enfileira(boolean tipoSenha) {

        this.aumentaCapacidade();
        int grupoPreferencial = 0;
        if (this.tamanho < this.senhas.length) {
            Senha senhaAdicionada = new Senha();
            for (int i = 0; i < tamanho+1; i++) {
                if (this.senhas[i] == null) {
                   senhaAdicionada =  moldaObjetoSenha(senhaAdicionada, tipoSenha);
                    this.senhas[i] = senhaAdicionada;
                    this.tamanho++;
                    return this.senhas[i].toString();
                }
                else if(this.senhas[i].isPreferencial()){
                    grupoPreferencial++;
                    if(this.senhas[i].parteGrupo == true){
                        grupoPreferencial--;
                    }
                    continue;
                    
                }else if(i==0){
                   if(this.senhas[i].isPreferencial()==false && tipoSenha && grupoPreferencial<3 && this.senhas[i].parteGrupo == false){
                    senhaAdicionada =  moldaObjetoSenha(senhaAdicionada, tipoSenha);
                    int posicaoAdicionarSenha = i;
                    for(int j=tamanho; j>i;j--){
                        Senha senhaTemporaria = this.senhas[j+1];
                        this.senhas[j] = this.senhas[j-1];

                    }this.senhas[posicaoAdicionarSenha] = senhaAdicionada;
                    this.tamanho++;
                    return this.senhas[i].toString();
                } 
                }
                
                else if(this.senhas[i].isPreferencial()==false && tipoSenha && grupoPreferencial<3 && this.senhas[i-1].parteGrupo == false && this.senhas[i].parteGrupo == false){
                    senhaAdicionada =  moldaObjetoSenha(senhaAdicionada, tipoSenha);
                    int posicaoAdicionarSenha = i;
                    for(int j=tamanho; j>i;j--){
                        Senha senhaTemporaria = this.senhas[j+1];
                        this.senhas[j] = this.senhas[j-1];

                    }this.senhas[posicaoAdicionarSenha] = senhaAdicionada;
                    this.tamanho++;
                    return this.senhas[i].toString();
                }else if(grupoPreferencial==3){
                    for(int k = i; k>i-3; k--){
                        this.senhas[k-1].parteGrupo = true;
                    }
                    grupoPreferencial=0;
                    continue;
                }//else if()
            }

 
           
        }
        return "Impossivel adicionar senha";
    }
    public Senha moldaObjetoSenha(Senha senhaAdicionada, boolean tipoSenha){
        if (tipoSenha) {
                this.qntSenhaPref++;
                senhaAdicionada.setCodigo("P" + Integer.toString(this.qntSenhaPref));
                senhaAdicionada.setPreferencial(tipoSenha);
            } else {
                this.qntSenhaComum++;
                senhaAdicionada.setCodigo("C" + Integer.toString(this.qntSenhaComum));
                senhaAdicionada.setPreferencial(tipoSenha);

 
            }
        return senhaAdicionada;
    }
    public boolean enfileiraPosicao(int posicao, Senha elemento) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posicao Inválida");
        }
        this.aumentaCapacidade();
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.senhas[i + 1] = this.senhas[i];
        }
        this.senhas[posicao] = elemento;
        this.tamanho++;
 
        return true;
    }
 
    public void aumentaCapacidade() {
        if (this.tamanho >= this.senhas.length-2) {
            Senha[] senhasNovo = new Senha[this.senhas.length * 2];
            for (int i = 0; i < this.senhas.length; i++) {
                senhasNovo[i] = this.senhas[i];
            }
            this.senhas = senhasNovo;
        }
    }
 
    public int tamanho() {
        return this.tamanho;
    }
 
    public int tamanhoEstrutura() {
        this.tamanhoEstrutura = this.senhas.length;
        return this.tamanhoEstrutura;
    }
 
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
 
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.senhas[i].getCodigo());
            s.append(",");
        }
        if (this.tamanho > 0) {
            s.append(this.senhas[this.tamanho - 1]);
        }
        s.append("]");
 
        return s.toString();
    }
 
    public boolean estaVazia() {
        return this.tamanho == 0;
 
    }
 
    public String remove(String senhaRemovida) {
        String codigoRemovido = "";
        for (int i = 0; i < tamanho; i++) {
            if (senhas[i].getCodigo().equals(senhaRemovida)) {
                codigoRemovido = senhas[i].getCodigo();
                for (int j = i; j < tamanho; j++) {
                    this.senhas[j] = this.senhas[j + 1];
                }
                tamanho--;
                return "Senha: " + codigoRemovido + " removida";
            }
        }
        return "Senha invalida";
        // for(int i = posicao; i < tamanho-1; i++){
        //   senhas[i] = senhas[i+1];
        // }
 
    }
 
    public String remove() {
        if (this.tamanho > 0) {
            String codigoRemovido = senhas[0].getCodigo();
            for (int i = 0; i < tamanho; i++) {
 
                this.senhas[i] = this.senhas[i + 1];
            }
 
            tamanho--;
            return codigoRemovido;
        }
 
        return "Não é possível fazer essa ação, fila vazia";
    }
    // for(int i = posicao; i < tamanho-1; i++){
    //   senhas[i] = senhas[i+1];
    // }
 
    public Senha espiar() {
        if (this.estaVazia()) {
            return null;
        }
        return this.senhas[0];
    }
 
    public Senha desenfileira() {
        if (this.estaVazia()) {
            return null;
        }
 
        Senha senhaASerRemovido = this.senhas[0];
        this.remove();
        return senhaASerRemovido;
    }
 
}