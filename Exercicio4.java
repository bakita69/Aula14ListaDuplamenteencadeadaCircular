/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.package1.exercicio4;


/**
 *
 * @author okmen
 */
class No {
    int valor;
    No anterior, proximo;

    No(int valor) {
        this.valor = valor;
        this.anterior = this;
        this.proximo = this;
    }
}

class ListaDuplamenteCircular {
    No cabeca;

    ListaDuplamenteCircular() {
        cabeca = null;
    }

    int contar() {
        if (cabeca == null) return 0;
        int count = 1;
        No atual = cabeca.proximo;
        while (atual != cabeca) {
            count++;
            atual = atual.proximo;
        }
        return count;
    }

    void inserirEsquerda(int valor) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No anterior = cabeca.anterior;
            novo.proximo = cabeca;
            novo.anterior = anterior;
            anterior.proximo = novo;
            cabeca.anterior = novo;
            cabeca = novo;
        }
    }

    void concatenar(ListaDuplamenteCircular outra) {
        if (outra.cabeca == null) return;
        if (this.cabeca == null) {
            this.cabeca = outra.cabeca;
            return;
        }

        No fim1 = this.cabeca.anterior;
        No fim2 = outra.cabeca.anterior;

        fim1.proximo = outra.cabeca;
        outra.cabeca.anterior = fim1;

        fim2.proximo = this.cabeca;
        this.cabeca.anterior = fim2;
    }

    static ListaDuplamenteCircular intercalarOrdenado(ListaDuplamenteCircular l1, ListaDuplamenteCircular l2) {
        ListaDuplamenteCircular resultado = new ListaDuplamenteCircular();
        No a = l1.cabeca;
        No b = l2.cabeca;
        boolean voltamosA = false, voltamosB = false;

        while (!voltamosA || !voltamosB) {
            if ((a != null && !voltamosA) && (b == null || voltamosB || a.valor <= b.valor)) {
                resultado.inserirOrdenado(a.valor);
                a = a.proximo;
                if (a == l1.cabeca) voltamosA = true;
            } else if (b != null && !voltamosB) {
                resultado.inserirOrdenado(b.valor);
                b = b.proximo;
                if (b == l2.cabeca) voltamosB = true;
            }
        }

        return resultado;
    }

    void inserirOrdenado(int valor) {
        No novo = new No(valor);
        if (cabeca == null) {
            cabeca = novo;
        } else {
            No atual = cabeca;
            do {
                if (valor < atual.valor) break;
                atual = atual.proximo;
            } while (atual != cabeca);

            No anterior = atual.anterior;
            anterior.proximo = novo;
            novo.anterior = anterior;
            novo.proximo = atual;
            atual.anterior = novo;

            if (atual == cabeca && valor < cabeca.valor) {
                cabeca = novo;
            }
        }
    }

    ListaDuplamenteCircular copiar() {
        ListaDuplamenteCircular copia = new ListaDuplamenteCircular();
        if (cabeca == null) return copia;

        No atual = cabeca;
        do {
            copia.inserirEsquerda(atual.valor);
            atual = atual.proximo;
        } while (atual != cabeca);

        return copia;
    }

    void imprimir() {
        if (cabeca == null) return;
        No atual = cabeca;
        do {
            System.out.print(atual.valor + " ");
            atual = atual.proximo;
        } while (atual != cabeca);
        System.out.println();
    }
}
