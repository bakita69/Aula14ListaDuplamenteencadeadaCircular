/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q1;

/**
 *
 * @author iagom
 */
public class ListaDuplamenteEncadeada {
    private No primeiro;
    private No ultimo;
    private int tamanho;
    public ListaDuplamenteEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionar(int dado) {
        No novoNo = new No(dado);
        if (primeiro == null) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
            ultimo = novoNo;
        }
        tamanho++;
    }

    public void exibir() {
        No atual = primeiro;
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void concatenar(ListaDuplamenteEncadeada outraLista) {
        if (outraLista.estaVazia()) {
            return;
        }
        if (this.estaVazia()) {
            this.primeiro = outraLista.primeiro;
            this.ultimo = outraLista.ultimo;
            this.tamanho = outraLista.tamanho;
            return;
        }
        this.ultimo.proximo = outraLista.primeiro;
        outraLista.primeiro.anterior = this.ultimo;
        this.ultimo = outraLista.ultimo;
        this.tamanho += outraLista.tamanho;
    }

    public ListaDuplamenteEncadeada[] separar() {
        ListaDuplamenteEncadeada primeiraMetade = new ListaDuplamenteEncadeada();
        ListaDuplamenteEncadeada segundaMetade = new ListaDuplamenteEncadeada();

        if (this.estaVazia()) {
            return new ListaDuplamenteEncadeada[]{primeiraMetade, segundaMetade};
        }

        int metade = this.tamanho / 2;
        No atual = this.primeiro;

        for (int i = 0; i < metade; i++) {
            primeiraMetade.adicionar(atual.dado);
            atual = atual.proximo;
        }

        while (atual != null) {
            segundaMetade.adicionar(atual.dado);
            atual = atual.proximo;
        }

        return new ListaDuplamenteEncadeada[]{primeiraMetade, segundaMetade};
    }


    public static ListaDuplamenteEncadeada intercalar(ListaDuplamenteEncadeada lista1, ListaDuplamenteEncadeada lista2) {
        ListaDuplamenteEncadeada resultado = new ListaDuplamenteEncadeada();
        No atual1 = lista1.primeiro;
        No atual2 = lista2.primeiro;

        while (atual1 != null && atual2 != null) {
            if (atual1.dado <= atual2.dado) {
                resultado.adicionar(atual1.dado);
                atual1 = atual1.proximo;
            } else {
                resultado.adicionar(atual2.dado);
                atual2 = atual2.proximo;
            }
        }

        while (atual1 != null) {
            resultado.adicionar(atual1.dado);
            atual1 = atual1.proximo;
        }

        while (atual2 != null) {
            resultado.adicionar(atual2.dado);
            atual2 = atual2.proximo;
        }

        return resultado;
    }
}
