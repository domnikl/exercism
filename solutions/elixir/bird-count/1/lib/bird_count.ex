defmodule BirdCount do
  def today([]), do: nil
  def today([head | _]) do
    head
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([head | tail]) do
    [head + 1 | tail]
  end

  def has_day_without_birds?(list) do
    Enum.any?(list, fn x -> x == 0 end)
  end

  def total(list) do
    list |> Enum.reduce(0, fn x, acc -> x + acc end)
  end

  def busy_days(list) do
    list |> Enum.count(fn x -> x >= 5 end)
  end
end
