export function isPangram(input: string): boolean {
  return "abcdefghijklmnopqrstuvwxyz"
    .split("")
    .every(x => input.toLowerCase().includes(x))
}
