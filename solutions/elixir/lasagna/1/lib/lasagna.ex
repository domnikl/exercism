defmodule Lasagna do

  @doc """
  Lasagna is a delicious food that can be eaten at any time of the day.

  This module provides functions to calculate the time needed to cook a lasagna.

  ```elixir
  iex> Lasagna.expected_minutes_in_oven()
  40
  ```
  """
  def expected_minutes_in_oven do
    40
  end

  @doc """
  Calculates the remaining minutes based on the time already spent in the oven.

  ## Examples

  ```elixir
  iex> Lasagna.remaining_minutes_in_oven(15)
  25
  ```
  """
  def remaining_minutes_in_oven(time) do
    expected_minutes_in_oven() - time
  end

  @doc """
  Calculates the total time needed to cook the lasagna.

  ```elixir
  iex> Lasagna.preparation_time_in_minutes(4)
  8
  ```
  """
  def preparation_time_in_minutes(layers) do
    layers * 2
  end

  @doc """
  Calculates the total time needed to cook the lasagna.

  ```elixir
  iex> Lasagna.total_time_in_minutes(4, 15)
  23
  ```
  """
  def total_time_in_minutes(layers, time) do
    preparation_time_in_minutes(layers) + time
  end

  @doc """
  Returns a message to remind you to take the lasagna out of the oven.
  """
  def alarm do
    "Ding!"
  end
end
