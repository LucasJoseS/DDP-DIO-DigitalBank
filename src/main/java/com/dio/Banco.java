package com.dio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {
  private List<Usuario> usuarios;
  private List<IConta> contas;

  /*
   * Gera um banco com dados de exemplo
   */
  public Banco() {
    this.usuarios = Arrays.asList(new Usuario("Lucas"), new Usuario("Jose"));
    this.contas = Arrays.asList(new ContaCorrente(this.getUsuario("Lucas"), 100d),
        new ContaCorrente(this.getUsuario("Jose"), 0d),
        new ContaPoupanca(this.getUsuario("Lucas"), 0d),
        new ContaPoupanca(this.getUsuario("Jose"), 0d));
  }

  public void depositar(String contaId, Double valor) {
    IConta conta = getConta(contaId);
    conta.depositar(valor);

    System.out
        .println("Deposito. Conta: " + contaId + ", Valor: " + valor + ", Saldo atual: " + ((Conta) conta).getSaldo());
  }

  public void sacar(String contaId, double valor) {
    IConta conta = getConta(contaId);
    conta.sacar(valor);

    System.out
        .println("Saque. Conta: " + contaId + ", Valor: " + valor + ", Saldo atual: " + ((Conta) conta).getSaldo());
  }

  public void transferir(String contaIdAlvo, String contaIdDestino, double valor) {
    IConta alvo = getConta(contaIdAlvo);
    IConta destino = getConta(contaIdDestino);
    alvo.tranferir(destino, valor);

    System.out.println("Transferir.");
    System.out
        .println("Alvo. Conta: " + contaIdAlvo + ", Valor: " + valor + ", Saldo atual: " + ((Conta) alvo).getSaldo());
    System.out
        .println(
            "Destino. Conta: " + contaIdDestino + ", Valor: " + valor + ", Saldo atual: "
                + ((Conta) destino).getSaldo());
  }

  private IConta getConta(String contaId) {
    return this.contas.stream().filter(c -> ((Conta) c).getId().equals(contaId)).collect(Collectors.toList()).get(0);
  }

  private Usuario getUsuario(String nome) {
    return this.usuarios.stream().filter(usuario -> usuario.getNome() == nome).collect(Collectors.toList()).get(0);
  }
}
