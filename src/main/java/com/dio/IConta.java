package com.dio;

/**
 * IConta
 */
public interface IConta {
  public void depositar(Double valor);

  public void sacar(Double valor);

  public void tranferir(IConta destino, Double valor);
}
