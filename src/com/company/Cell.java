package com.company;

public class Cell {
  Integer type;
  Integer h;
  Integer w;


  public Cell(Integer type, Integer h, Integer w) {
    this.type = type;
    this.h = h;
    this.w = w;

  }

  public Cell(Cell c) {
    this.type = c.type;
    this.h = c.h;
    this.w = c.w;
  }

  public Cell(Integer type) {
    this.type = type;

  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getH() {
    return h;
  }

  public void setH(Integer h) {
    this.h = h;
  }

  public Integer getW() {
    return w;
  }

  public void setW(Integer w) {
    this.w = w;
  }

  @Override
  public boolean equals(Object obj) {
    Cell cell = (Cell) obj;
    return (this.type == cell.type && this.h == cell.h && cell.w == this.w);
  }

  @Override
  public int hashCode() {
    return this.type * 97 + this.w * 53 + this.h * 37;
  }

}

