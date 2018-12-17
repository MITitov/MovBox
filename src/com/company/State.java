package com.company;

public class State {
Cell b1,b2;
Double route = 0D;
Integer hash = 0;

  @Override
  public boolean equals(Object obj) {
    State state = (State) obj;
    return state.b1.equals(this.b1) && state.b2.equals(this.b2);
  }

  @Override
  public int hashCode() {
    return this.b1.hashCode()*19 + this.b2.hashCode()*71;
  }

  public State(Cell b1, Cell b2) {
    this.b1 = b1;
    this.b2 = b2;
    this.hash = hashCode();
  }

  public Cell getB1() {
    return b1;
  }

  public void setB1(Cell b1) {
    this.b1 = b1;
  }

  public Cell getB2() {
    return b2;
  }

  public void setB2(Cell b2) {
    this.b2 = b2;
  }

}
