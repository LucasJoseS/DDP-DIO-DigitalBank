package com.dio;

public class App {
  public static void main(String[] args) {
    Banco banco = new Banco();

    banco.depositar("CC-Lucas", 100d);
    banco.sacar("CC-Lucas", 100d);
    banco.transferir("CC-Lucas", "CP-Lucas", 100d);
  }
}
