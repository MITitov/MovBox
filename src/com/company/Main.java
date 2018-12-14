package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  static Integer w, h, test;

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\SWT\\MovingBoxes\\sample_input.txt"));
      String str;
      str = br.readLine();
      test = Integer.valueOf(str);
//      Set<State> turns = new HashSet<>();
      Set<State> turns = Collections.newSetFromMap(new ConcurrentHashMap<>());
      int result = -1;
      for (int i = 0; i < test; i++) {
        turns.clear();
        String[] size = br.readLine().split(" ");
        h = Integer.valueOf(size[0]);
        w = Integer.valueOf(size[1]);
        Table field = new Table(h, w);
        State state = new State(new Cell(1, 0, 0), new Cell(2, 0, 0));
        for (int j = 0; j < h; j++) {
          String[] sarr = br.readLine().split(" ");
          for (int k = 0; k < sarr.length; k++) {
            field.table[j][k].setType(Integer.valueOf(sarr[k]));

            switch (Integer.valueOf(sarr[k])) {
              case 1:
                state.setB1(new Cell(1, j, k));
                field.table[j][k].setType(0);
                break;
              case 2:
                state.setB2(new Cell(2, j, k));
                field.table[j][k].setType(0);
                break;
              case -1:
                field.f1 = new Cell(-1, j, k);
                break;
              case -2:
                field.f2 = new Cell(-2, j, k);
                break;
              case 9:
//                field.blocks.add(new Cell(9, j, k));
                break;
            }
          }
        }
        if (field.checkProbability()) {
          turns.add(state);
//        field.print(state.b1,state.b2);
//        state = field.moveUp(state.b1, state.b2);
//        field.print(state.b1,state.b2);
//        state = field.moveDown(state.b1, state.b2);
//        field.print(state.b1,state.b2);
          //output

          finish:
          for (int j = 0; j < 8; j++) {
            Iterator it = turns.iterator();
            while (it.hasNext()) {
              State start = (State) it.next();
//            State cur = new State(new Cell(0, 0, 0), new Cell(0, 0, 0));
              if (field.check(start)) {
                result = j;
                break finish;
              }
              State cur = field.moveLeft(start.b1, start.b2);
              turns.add(cur);

              cur = field.moveRight(start.b1, start.b2);
              turns.add(cur);

              cur = field.moveDown(start.b1, start.b2);
              turns.add(cur);

              cur = field.moveUp(start.b1, start.b2);
              turns.add(cur);
            }
          }
        }
        System.out.println("turns = " + result);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
