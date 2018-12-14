package com.company;

public class Table {
  public Cell[][] table;
  private int h, w;
  Cell f1, f2;

  public Table(int h, int w) {
    this.h = h;
    this.w = w;
    this.table = new Cell[h][w];
    for (int i = 0; i < h; i++) {
      for (int j = 0; j < w; j++) {
        table[i][j] = new Cell(0);
      }
    }

  }

  public Cell[][] getTable() {
    return table;
  }

  public void setTable(Cell[][] table) {
    this.table = table;
  }

  public State moveUp(Cell b1, Cell b2) {
    State s = new State(new Cell(b1), new Cell(b2));
    table[s.b1.h][s.b1.w].type = 1;
    table[s.b2.h][s.b2.w].type = 2;
    boolean moved = false;
    if (s.b1.h < s.b2.h) {
      if (s.b1.h == 1) {
      } else {
        do {
          moved = false;
          if (s.b1.h != 0) {
            if (table[s.b1.h - 1][s.b1.w].type <= 0) {
              moved = true;
              table[s.b1.h - 1][s.b1.w].type = 1;
              table[s.b1.h][s.b1.w].type = 0;
              s.b1.h--;
            }
          }
        } while (moved && s.b1.h > 0);
      }
      do {
        moved = false;
        if (s.b2.h != 0) {
          if (table[s.b2.h - 1][s.b2.w].type <= 0) {
            table[s.b2.h - 1][s.b2.w].type = 2;
            table[s.b2.h][s.b2.w].type = 0;
            s.b2.h--;
            moved = true;
          }
        }
      } while (moved && s.b2.h > 0);
    } else {
      if (s.b2.h == 1) {
        do {
          moved = false;
          if (table[s.b2.h - 1][s.b2.w].type <= 0) {
            moved = true;
            table[s.b2.h - 1][s.b2.w].type = 2;
            table[s.b2.h][s.b2.w].type = 0;
            s.b2.h--;
          }
        } while (moved && s.b2.h > 0);
      }
      do {
        moved = false;
        if (s.b1.h != 0) {
          if (table[s.b1.h - 1][s.b1.w].type <= 0) {
            table[s.b1.h - 1][s.b1.w].type = 1;
            table[s.b1.h][s.b1.w].type = 0;
            s.b1.h--;
            moved = true;
          }
        }
      } while (moved && s.b1.h > 0);
    }
    table[s.b1.h][s.b1.w].type = 0;
    table[s.b2.h][s.b2.w].type = 0;
    return s;
  }

  public State moveDown(Cell b1, Cell b2) {
    boolean moved = false;
    State s = new State(new Cell(b1), new Cell(b2));
    table[s.b1.h][s.b1.w].type = 1;
    table[s.b2.h][s.b2.w].type = 2;
    if (s.b1.h > s.b2.h) {
      if (s.b1.h != h) {
      } else {
        do {
          moved = false;
          if (s.b1.h != h - 1) {
            if (table[s.b1.h + 1][s.b1.w].type <= 0) {
              moved = true;
              table[s.b1.h + 1][s.b1.w].type = 1;
              table[s.b1.h][s.b1.w].type = 0;
              s.b1.h++;
            }
          }
        } while (moved && s.b1.h < h - 1);
      }
      do {
        moved = false;
        if (s.b2.h != h - 1) {
          if (table[s.b2.h + 1][s.b2.w].type <= 0) {
            table[s.b2.h + 1][s.b2.w].type = 2;
            table[s.b2.h][s.b2.w].type = 0;
            s.b2.h++;
            moved = true;
          }
        }
      } while (moved && s.b2.h < h - 1);
    } else {
      if (s.b2.h != h - 1) {
        do {
          moved = false;
          if (s.b2.h != h - 1) {
            if (table[s.b2.h + 1][s.b2.w].type <= 0) {
              moved = true;
              table[s.b2.h + 1][s.b2.w].type = 2;
              table[s.b2.h][s.b2.w].type = 0;
              s.b2.h++;
            }
          }
        } while (moved && s.b2.h < h - 1);
      }
      do {
        moved = false;
        if (s.b1.h != h - 1) {
          if (table[s.b1.h + 1][s.b1.w].type <= 0) {
            table[s.b1.h + 1][s.b1.w].type = 1;
            table[s.b1.h][s.b1.w].type = 0;
            s.b1.h++;
            moved = true;
          }
        }
      } while (moved && s.b1.h < h - 1);
    }
    table[s.b1.h][s.b1.w].type = 0;
    table[s.b2.h][s.b2.w].type = 0;
    return s;
  }

  public State moveRight(Cell b1, Cell b2) {
    boolean moved = false;
    State s = new State(new Cell(b1), new Cell(b2));
    table[s.b1.h][s.b1.w].type = 1;
    table[s.b2.h][s.b2.w].type = 2;
    if (s.b1.w > s.b2.w) {
      if (s.b1.w != w - 1) {
      } else {
        do {
          moved = false;
          if (s.b1.w != w - 1) {
            if (table[s.b1.h][s.b1.w + 1].type <= 0) {
              moved = true;
              table[s.b1.h][s.b1.w + 1].type = 1;
              table[s.b1.h][s.b1.w].type = 0;
              s.b1.w++;
            }
          }
        } while (moved && b1.w < w - 1);
      }
      do {
        moved = false;
        if (s.b2.w != w - 1) {
          if (table[s.b2.h][s.b2.w + 1].type <= 0) {
            table[s.b2.h][s.b2.w + 1].type = 2;
            table[s.b2.h][s.b2.w].type = 0;
            s.b2.w++;
            moved = true;
          }
        }
      } while (moved && s.b2.w < w - 1);
    } else {
      if (s.b2.w != w - 1) {
        do {
          moved = false;
          if (s.b2.w != w - 1) {
            if (table[s.b2.h][s.b2.w + 1].type <= 0) {
              moved = true;
              table[s.b2.h][s.b2.w + 1].type = 2;
              table[s.b2.h][s.b2.w].type = 0;
              s.b2.w++;
            }
          }
        } while (moved && s.b2.w < w - 1);
      }
      do {
        moved = false;
        if (s.b1.w != w - 1) {
          if (table[s.b1.h][s.b1.w + 1].type <= 0) {
            table[s.b1.h][s.b1.w + 1].type = 1;
            table[s.b1.h][s.b1.w].type = 0;
            s.b1.w++;
            moved = true;
          }
        }
      } while (moved && s.b1.w < w - 1);
    }
    table[s.b1.h][s.b1.w].type = 0;
    table[s.b2.h][s.b2.w].type = 0;
    return s;
  }

  public State moveLeft(Cell b1, Cell b2) {
    State s = new State(new Cell(b1), new Cell(b2));
    table[s.b1.h][s.b1.w].type = 1;
    table[s.b2.h][s.b2.w].type = 2;
    boolean moved = false;
    if (s.b1.w < s.b2.w) {
      if (s.b1.w != 0) {
      } else {
        do {
          moved = false;
          if (s.b1.w != 0) {
            if (table[s.b1.h][s.b1.w - 1].type <= 0) {
              moved = true;
              table[s.b1.h][s.b1.w - 1].type = 1;
              table[s.b1.h][s.b1.w].type = 0;
              s.b1.w--;
            }
          }
        } while (moved && s.b1.w > 0);
      }
      do {
        moved = false;
        if (s.b2.w != 0) {
          if (table[s.b2.h][s.b2.w - 1].type <= 0) {
            table[s.b2.h][s.b2.w - 1].type = 2;
            table[s.b2.h][s.b2.w].type = 0;
            s.b2.w--;
            moved = true;
          }
        }
      } while (moved && s.b2.w > 0);
    } else {
      if (s.b2.w != 0) {
        do {
          moved = false;
          if (s.b2.w != 0) {
            if (table[s.b2.h][s.b2.w - 1].type <= 0) {
              moved = true;
              table[s.b2.h][s.b2.w - 1].type = 2;
              table[s.b2.h][s.b2.w].type = 0;
              s.b2.w--;
            }
          }
        } while (moved && s.b2.w > 0);
      }
      do {
        moved = false;
        if (s.b1.w != 0) {
          if (table[s.b1.h][s.b1.w - 1].type <= 0) {
            table[s.b1.h][s.b1.w - 1].type = 1;
            table[s.b1.h][s.b1.w].type = 0;
            s.b1.w--;
            moved = true;
          }
        }
      } while (moved && b1.w > 0);
    }
    table[s.b1.h][s.b1.w].type = 0;
    table[s.b2.h][s.b2.w].type = 0;
    return s;
  }

  public void print() {
//    table[b1.h][b1.w].type = 1;
//    table[b2.h][b2.w].type = 2;
    for (int j = 0; j < h; j++) {
      for (int k = 0; k < w; k++) {
        System.out.print(table[j][k].type);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }

  public void print(Cell b1, Cell b2) {
    table[b1.h][b1.w].type = 1;
    table[b2.h][b2.w].type = 2;
    for (int j = 0; j < h; j++) {
      for (int k = 0; k < w; k++) {
        System.out.print(table[j][k].type);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
    table[b1.h][b1.w].type = 0;
    table[b2.h][b2.w].type = 0;
  }

  public boolean check(State state) {
    return state.b1.h == f1.h && state.b1.w == f1.w && state.b2.h == f2.h && state.b2.w == f2.w;
  }

  public boolean checkProbability() {
    boolean result = false;
    try {
      if (table[f1.h + 1][f1.w].type > 0 ||
              table[f1.h + 2][f1.w].type > 0 ||
              table[f1.h - 1][f1.w].type > 0 ||
              table[f1.h - 2][f1.w].type > 0 ||
              table[f1.h][f1.w + 1].type > 0 ||
              table[f1.h][f1.w + 2].type > 0 ||
              table[f1.h][f1.w - 1].type > 0 ||
              table[f1.h][f1.w - 2].type > 0 ||
              table[f2.h + 1][f2.w].type > 0 ||
              table[f2.h + 2][f2.w].type > 0 ||
              table[f2.h - 1][f2.w].type > 0 ||
              table[f2.h - 2][f2.w].type > 0 ||
              table[f2.h][f2.w + 1].type > 0 ||
              table[f2.h][f2.w + 2].type > 0 ||
              table[f2.h][f2.w - 1].type > 0 ||
              table[f2.h][f2.w - 2].type > 0) {
        result = true;
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      result = true;
    }
    return result;
  }
}