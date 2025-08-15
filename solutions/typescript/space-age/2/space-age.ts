declare global {
    interface Number {
        round(n: number): number;
    }
}

Number.prototype.round = function (this: number, n: number): number {
  return Math.round(this * Math.pow(10, n)) / Math.pow(10, n);
}

function mapPlanetToFactor(planet: string): number {
  switch (planet) {
    case 'mercury': return 0.2408467;
    case 'venus': return 0.61519726;
    case 'earth': return 1;
    case 'mars': return 1.8808158;
    case 'jupiter': return 11.862615;
    case 'saturn': return 29.447498;
    case 'uranus': return 84.016846;
    case 'neptune': return 164.79132;
  }

  throw new Error("Unkown planet");
}

export function age(planet: string, age: number): number {
  const factor = mapPlanetToFactor(planet);
  const earthAge = age / factor;
  const earthYears = earthAge / 31557600

  return earthYears.round(2);
}
