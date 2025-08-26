defmodule RemoteControlCar do
  @enforce_keys [:nickname]
  defstruct battery_percentage: 100,
            distance_driven_in_meters: 0,
            nickname: nil

  def new(nickname \\ "none") do
    %RemoteControlCar{nickname: nickname}
  end

  def display_distance(%RemoteControlCar{distance_driven_in_meters: distance}) do
    "#{distance} meters"
  end

  def display_battery(%RemoteControlCar{battery_percentage: 0}) do
    "Battery empty"
  end

  def display_battery(%RemoteControlCar{battery_percentage: battery}) do
    "Battery at #{battery}%"
  end

  def drive(
        %RemoteControlCar{battery_percentage: battery, distance_driven_in_meters: distance} =
          remote_car
      ) do
    if battery > 0 do
      new_distance = distance + 20
      new_battery = battery - 1

      %RemoteControlCar{
        remote_car
        | distance_driven_in_meters: new_distance,
          battery_percentage: new_battery
      }
    else
      remote_car
    end
  end
end
