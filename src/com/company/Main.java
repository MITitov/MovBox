package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

  static Integer w, h, test;

  public static void main(String[] args) {
    try {
      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Maksim\\Desktop\\SWT\\MovingBoxes\\sample_input.txt"));
//      Scanner sc = new Scanner(System.in);
//      test = sc.nextInt();
      String str = br.readLine();
      test = Integer.valueOf(str);
//      Set<State> turns = new HashSet<>();
      Set<State> turns = Collections.newSetFromMap(new ConcurrentHashMap<>());



      for (int i = 0; i < test; i++) {
        int result = -1;
        Double route = 0D;
        State[] states = new State[10000];
        int sss = 0;
//        turns.clear();
        String[] size = br.readLine().split(" ");
        h = Integer.valueOf(size[0]);
        w = Integer.valueOf(size[1]);
        Table field = new Table(h, w);
        State state = new State(new Cell(1, 0, 0), new Cell(2, 0, 0));
        for (int j = 0; j < h; j++) {
          String[] sarr = br.readLine().split(" ");
          for (int k = 0; k < sarr.length; k++) {
            field.table[j][k].setType(Integer.valueOf(sarr[k]));
            field.setInitial(j, k, Integer.valueOf(sarr[k]));
            switch (Integer.valueOf(sarr[k])) {
              case 1:
                state.setB1(new Cell(1, j, k));
                field.table[j][k].setType(0);
                field.setInitial(j, k, 0);
                break;
              case 2:
                state.setB2(new Cell(2, j, k));
                field.table[j][k].setType(0);
                field.setInitial(j, k, 0);
                break;
              case -1:
                field.f1 = new Cell(-1, j, k);
                field.setInitial(j, k, -1);
                break;
              case -2:
                field.f2 = new Cell(-2, j, k);
                field.setInitial(j, k, -2);
                break;
              case 9:
//                field.blocks.add(new Cell(9, j, k));
                break;
            }
          }
        }
        if (field.checkProbability()) {
          turns.add(state);
          states[sss++] = state;
          Integer zeroState = sss;
//        field.print(state.b1,state.b2);
//        state = field.moveRight(state.b1, state.b2);
//        field.print(state.b1,state.b2);
//        state = field.moveDown(state.b1, state.b2);
//        field.print(state.b1,state.b2);
//        state = field.moveLeft(state.b1, state.b2);
//        field.print(state.b1,state.b2);
//        state = field.moveUp(state.b1, state.b2);
//        field.print(state.b1,state.b2);

          finish:
          for (int j = 0; j < 9; j++) {
            for (int k = 0; k < zeroState; k++) {
              State start = states[k];
              if (field.check(start)) {
                result = j;
                route = start.route;
                break finish;
              }
              State cur = field.moveLeft(start.b1, start.b2);
              cur.route = start.route + Math.pow(10, j);
//              turns.add(cur);
              if (put(states, sss, cur)) sss++;
//              states[sss] = cur;

              cur = field.moveRight(start.b1, start.b2);
              cur.route = start.route + Math.pow(10, j) * 2;
              if (put(states, sss, cur)) sss++;

              cur = field.moveDown(start.b1, start.b2);
              cur.route = start.route + Math.pow(10, j) * 3;
              if (put(states, sss, cur)) sss++;

              cur = field.moveUp(start.b1, start.b2);
              cur.route = start.route + Math.pow(10, j) * 4;
              if (put(states, sss, cur)) sss++;
            }
            zeroState = sss;
          }
        }
        System.out.println("turns = " + result);
        System.out.println("route = " + route);

//          finish:
//          for (int j = 0; j < 8; j++) {
//            Iterator it = turns.iterator();
//            while (it.hasNext()) {
//              State start = (State) it.next();
//              if (field.check(start)) {
//                result = j + 1;
//                route = start.route;
//                break finish;
//              }
//              State cur = field.moveLeft(start.b1, start.b2);
//              cur.route = start.route + Math.pow(10,j);
//              turns.add(cur);
//
//              cur = field.moveRight(start.b1, start.b2);
//              cur.route = start.route + Math.pow(10,j)*2;
//              turns.add(cur);
//
//              cur = field.moveDown(start.b1, start.b2);
//              cur.route = start.route + Math.pow(10,j)*3;
//              turns.add(cur);
//
//              cur = field.moveUp(start.b1, start.b2);
//              cur.route = start.route + Math.pow(10,j)*4;
//              turns.add(cur);
//            }
//          }
//        }
//        System.out.println("turns = " + result);
//        System.out.println("route = " + route);
//        turns.clear();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static boolean put(State[] states, int size, State cur) {
    boolean exist = false;
    for (int i = 0; i < size; i++) {
      exist = states[i].equals(cur);
      if (exist) return false;
    }
    states[size++] = cur;
    return true;

  }
}
