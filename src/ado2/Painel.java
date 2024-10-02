//VICTOR STEWERS OLIVEIRA - ADS - MATUTINO A
package ado2;

import javax.swing.JOptionPane;

public class Painel {

    public static void main(String[] args) {
        int opcao = 0;
        Fila fila = new Fila();
        Object[] opcoes = {"SOLICITAR SENHA",
            "EXCLUIR SENHA",
            "LISTA DE SENHAS",
            "VISUALIZAR PRÓXIMA SENHA",
            "CHAMAR PROXIMA SENHA",
            "SAIR"};

        do {
            opcao = telaInicial(opcoes);
            switch (opcao) {

                case 0:
                    Object[] tipo = {"Preferencial", "Comum"};
                    do{
                        try {
                            String tipoEscolhido = (String) JOptionPane.showInputDialog(null,
                            "Escolha o tipo de senha",
                            "Tipo senha",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            tipo,tipo[0]);
                    boolean preferencial;
                    
                    if(tipoEscolhido.equals("Preferencial")){
                        //System.out.println("opa");
                        preferencial = true;
                        String codigoAdd = fila.enfileira(preferencial);
                        JOptionPane.showMessageDialog(null,"Senha adicionada: "+ codigoAdd);
                        
                    }if(tipoEscolhido.equals("Comum")){
                        //System.out.println("eai man");
                        preferencial = false;
                        String codigoAdd = fila.enfileira(preferencial);
                        JOptionPane.showMessageDialog(null,"Senha adicionada: "+ codigoAdd);
                    }
                    break;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,"Selecione um tipo!!");
                        }
                    }while(true);
                   
                     break;
                case 1:
                    String senhaRemovida = JOptionPane.showInputDialog(null,"Qual a senha a ser removida?");
                    senhaRemovida = senhaRemovida.toUpperCase();
                    System.out.println(senhaRemovida);
                    String codigoRemovido = fila.remove(senhaRemovida);
                    JOptionPane.showMessageDialog(null, codigoRemovido);
                    break;
                case 2:
                    if(fila.toString().equals("[]")){
                        JOptionPane.showMessageDialog(null,"Fila vazia");
                    }else{
                        JOptionPane.showMessageDialog(null, fila.toString(),
                            "Fila de senhas", JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                    break;
                case 3:
                    if(fila.espiar()==null){
                        JOptionPane.showMessageDialog(null,"Fila vazia");
                    }else{
                        JOptionPane.showMessageDialog(null,fila.espiar());
                    
                    }
                    
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,fila.remove());
                    break;

            }

        } while (opcao != 5);
    }

    public static int telaInicial(Object[] opcoes) {
        int opcao = JOptionPane.showOptionDialog(
                null,
                "Selecione uma das opções",
                "Controlador de fila",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes, opcoes[0]);
        return opcao;
    }

}
