/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q1;

/**
 *
 * @author iagom
 */
public class ListaDuplamenteEncadeada2 {
    private No cabeca;
    private int tamanho;
    
    public ListaDuplamenteEncadeada2() {
        cabeca = new No(0); // Nó cabeça não armazena dado útil, apenas aponta
        cabeca.proximo = cabeca;
        cabeca.anterior = cabeca;
        tamanho = 0;
    }

    public void inserir(int dado) {
        No novoNo = new No(dado);
        novoNo.proximo = cabeca;
        novoNo.anterior = cabeca.anterior;
        cabeca.anterior.proximo = novoNo;
        cabeca.anterior = novoNo;
        tamanho++;
    }

    public boolean buscar(int dado) {
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            if (atual.dado == dado) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public boolean eliminar(int dado) {
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            if (atual.dado == dado) {
                atual.anterior.proximo = atual.proximo;
                atual.proximo.anterior = atual.anterior;
                tamanho--;
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }

    public void exibir() {
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int getTamanho() {
        return tamanho;
    }
}
