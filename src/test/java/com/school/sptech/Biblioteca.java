package com.school.sptech;

public class Biblioteca {
    private String nome;
    private  Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria){
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        qtdLivros = 0;
        ativa = true;
    }

    public void registrarLivro(Integer quantidade){
        if (quantidade > 0 && ativa == true){
            qtdLivros+=quantidade;
        }
    }

    public  Integer emprestar(Integer quantidade){
        if (ativa==true && quantidade >0 && quantidade
                <= qtdLivros && quantidade !=null){
            qtdLivros-=quantidade;
            return quantidade;
        } else {
            return null;
        }
    }
    public Integer devolver(Integer quantidade){
        if (ativa==true && quantidade>0 && quantidade!=null){
            qtdLivros+= quantidade;
            return quantidade;
        }
        else {
            return null;
        }
    }
    public Integer desativar(){
        if(ativa == false){
            return null;
        } else {
            ativa = false;
            Integer estoque = qtdLivros;
            qtdLivros =0;
            return estoque;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
       if (ativa && destino.ativa && quantidade!=null
       && quantidade>0 && quantidade<= qtdLivros){
           qtdLivros -= quantidade;
           destino.qtdLivros += quantidade;
       }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual>0 && percentual!=null){
            multaDiaria+= multaDiaria * percentual;
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
