package com.dio;

import lombok.Getter;
import lombok.Setter;

/**
 * Conta
 */
public abstract class Conta implements IConta {
  @Getter
  @Setter
  private Double saldo;

  @Getter
  @Setter
  private Usuario proprietario;

  public Conta(Usuario proprietario, Double depositoInicial) {
    setProprietario(proprietario);
    setSaldo(depositoInicial);
  }

  public abstract String getId();

  @Override
  public void depositar(Double valor) {
    setSaldo(getSaldo() + valor);
  }

  @Override
  public void sacar(Double valor) {
    setSaldo(getSaldo() - valor);
  }

  @Override
  public void tranferir(IConta destino, Double valor) {
    sacar(valor);
    destino.depositar(valor);
  }
}
