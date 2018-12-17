package com.company;

public class States {
  State[] states;
int size;
  public States() {
    states = new State[100];
    size = 0;
  }
  public void add(State state) {
    if (!exist(state)) {
      states[size++] = state;
    }
  }

  private boolean exist(State state) {
    boolean res = false;
    for (int i = 0;i<size;i++) {
      res = states[i].equals(state);
    }

    return res;
  }
}
