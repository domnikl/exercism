export function decodedValue(rings: string[]): number {
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
  ];

  const x = rings.map((e) => colors.indexOf(e))

  return x[0] * 10 + x[1]
}
