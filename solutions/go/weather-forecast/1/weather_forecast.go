// Package weather is the weather forecast package.
package weather

// CurrentCondition holds the current weather condition.
var CurrentCondition string
// CurrentLocation holds the current location.
var CurrentLocation string

// Forecast returns a string with the current weather conditions for the location.
func Forecast(city, condition string) string {
	CurrentLocation, CurrentCondition = city, condition
	return CurrentLocation + " - current weather condition: " + CurrentCondition
}
