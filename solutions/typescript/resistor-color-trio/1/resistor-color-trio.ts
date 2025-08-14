export function decodedResistorValue(rings: Array<string>) {
  const colors = [
    'black',
    'brown',
    'red',
    'orange',
    'yellow',
    'green',
    'blue',
    'violet',
    'grey',
    'white'
  ]

  const values = rings.map((e) => colors.indexOf(e));
  const value = (values[0] * 10 + values[1]) * Math.pow(10, values[2]);

  return value > 1000 ? `${value / 1000} kiloohms` : `${value} ohms`;
}
