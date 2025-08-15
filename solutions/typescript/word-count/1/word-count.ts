export function count(sentence: string): Map<string, number> {
  const words = sentence.trim().toLowerCase().split(/[\t\n ]+/)
  const occurences = new Map<string, number>()

  words?.forEach((word) => {
    if (occurences.has(word)) {
      occurences.set(word, occurences.get(word)!! + 1)
    } else {
      occurences.set(word, 1)
    }
  })

  return occurences
}
