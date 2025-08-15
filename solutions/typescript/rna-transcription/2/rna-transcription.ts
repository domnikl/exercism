function map(nucleotide: string): string {
  switch (nucleotide) {
    case 'G': return 'C';
    case 'C': return 'G';
    case 'T': return 'A';
    case 'A': return 'U';
    default: throw new Error('Invalid input DNA.')
  }
}

export function toRna(dna: string): string {
  return dna.split('')
    .map((nucleotide) => map(nucleotide))
    .join('')
}
