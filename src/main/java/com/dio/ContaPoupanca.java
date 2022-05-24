package com.dio;

public class ContaPoupanca extends Conta {
  public ContaPoupanca(Usuario proprietario, Double depositoInicial) {
    super(proprietario, depositoInicial);
  }

  @Override
  public String getId() {
    return "CP-" + super.getProprietario().getNome();
  }
}
