function map(dna: string): string {
  switch (dna) {
    case 'G': return 'C';
    case 'C': return 'G';
    case 'T': return 'A';
    case 'A': return 'U';
    default: throw new Error('Invalid input DNA.')
  }
}

export function toRna(dna: string) {
  let result = "";
  
  for (let i = 0; i < dna.length; i++) {
    result += map(dna[i])
  }
  
  return result;
}
