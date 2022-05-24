package com.dio;

public class ContaCorrente extends Conta {
  public ContaCorrente(Usuario proprietario, Double depositoInicial) {
    super(proprietario, depositoInicial);
  }

  @Override
  public String getId() {
    return "CC-" + getProprietario().getNome();
  }
}
