/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.q1;

/**
 *
 * @author iagom
 */
public class ListaEncadeadaCircular {
    private No cabeca; 
    
    public ListaEncadeadaCircular() {
        cabeca = null; 
    }

    public void adicionar(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
            cabeca.anterior = cabeca;
        } else {
            No ultimo = cabeca.anterior; 
            novoNo.proximo = cabeca;
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
            cabeca.anterior = novoNo;
        }
    }

    public void exibir() {
        if (cabeca == null) {
            System.out.println("Lista vazia.");
            return;
        }
        No atual = cabeca;
        do {
            System.out.print(atual.dado + " ");
            atual = atual.proximo;
        } while (atual != cabeca);
        System.out.println();
    }

    public int contarElementos() {
        if (cabeca == null) {
            return 0;
        }
        int count = 0;
        No atual = cabeca;
        do {
            count++;
            atual = atual.proximo;
        } while (atual != cabeca);
        return count;
    }

    public void inserirEsquerdaCabeca(int dado) {
        No novoNo = new No(dado);
        if (cabeca == null) {
            cabeca = novoNo;
            cabeca.proximo = cabeca;
            cabeca.anterior = cabeca;
        } else {
            No ultimo = cabeca.anterior;
            novoNo.proximo = cabeca;
            novoNo.anterior = ultimo;
            cabeca.anterior = novoNo;
            ultimo.proximo = novoNo;
            cabeca = novoNo; 
        }
    }

    public void concatenar(ListaEncadeadaCircular outraLista) {
        if (outraLista.cabeca == null) {
            return;
        }
        if (this.cabeca == null) {
            this.cabeca = outraLista.cabeca;
            return;
        }

        No thisUltimo = this.cabeca.anterior;
        No outraPrimeiro = outraLista.cabeca;
        No outraUltimo = outraLista.cabeca.anterior;

        thisUltimo.proximo = outraPrimeiro;
        outraPrimeiro.anterior = thisUltimo;
        outraUltimo.proximo = this.cabeca;
        this.cabeca.anterior = outraUltimo;
    }

    public static ListaEncadeadaCircular intercalar(ListaEncadeadaCircular lista1, ListaEncadeadaCircular lista2) {
        ListaEncadeadaCircular resultado = new ListaEncadeadaCircular();

        if (lista1.cabeca == null && lista2.cabeca == null) {
            return resultado;
        }

        No atual1 = (lista1.cabeca == null) ? null : lista1.cabeca;
        No atual2 = (lista2.cabeca == null) ? null : lista2.cabeca;

        int count1 = 0;
        int count2 = 0;
        int total1 = lista1.contarElementos();
        int total2 = lista2.contarElementos();

        while ((atual1 != null && count1 < total1) && (atual2 != null && count2 < total2)) {
            if (atual1.dado <= atual2.dado) {
                resultado.adicionar(atual1.dado);
                atual1 = atual1.proximo;
                count1++;
            } else {
                resultado.adicionar(atual2.dado);
                atual2 = atual2.proximo;
                count2++;
            }
        }

        while (atual1 != null && count1 < total1) {
            resultado.adicionar(atual1.dado);
            atual1 = atual1.proximo;
            count1++;
        }

        while (atual2 != null && count2 < total2) {
            resultado.adicionar(atual2.dado);
            atual2 = atual2.proximo;
            count2++;
        }

        return resultado;
    }

    public ListaEncadeadaCircular fazerCopia() {
        ListaEncadeadaCircular copia = new ListaEncadeadaCircular();
        if (this.cabeca == null) {
            return copia;
        }

        No atual = this.cabeca;
        do {
            copia.adicionar(atual.dado);
            atual = atual.proximo;
        } while (atual != this.cabeca);

        return copia;
    }
}
