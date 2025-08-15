export function hey(message: string): string {
  const m = message.trim()
  const isYelling = m.match(/[A-Z]/g) && m === m.toUpperCase()
  const isQuestion = m[m.length - 1] === '?'

  if (m.length == 0) {
    return 'Fine. Be that way!'
  } else if (isQuestion && isYelling) {
      return 'Calm down, I know what I\'m doing!'
  } else if (isQuestion) {
    return 'Sure.'
  } else if (isYelling) {
    return 'Whoa, chill out!'
  }
  
  return 'Whatever.'
}
