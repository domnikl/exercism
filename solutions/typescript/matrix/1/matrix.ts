export class Matrix {
  _rows: number[][];
  _cols: number[][];
  
  constructor(input: string) {
    this._rows = input.split("\n").map((x) => x.split(" ").map(i => parseInt(i)))
    this._cols = this._rows[0].map((_, i: number) => this._rows.map((x: number[]) => x[i]))   
  }

  get rows(): number[][] {
    return this._rows;
  }

  get columns(): number[][] {
    return this._cols;
  }
}
