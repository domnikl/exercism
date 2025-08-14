defmodule BirdCount do
  def today([]), do: nil
  def today([head | _]) do
    head
  end

  def increment_day_count([]), do: [1]
  def increment_day_count([head | tail]) do
    [head + 1 | tail]
  end

  def has_day_without_birds?([]), do: false
  def has_day_without_birds?([head | tail]) do
    if head == 0, do: true, else: has_day_without_birds?(tail)
  end

  def total(list) do
    total(list, 0)
  end
  def total([], total), do: total
  def total([head | tail], total) do
    total(tail, total + head)
  end

  def busy_days(list) do
    busy_days(list, 0)
  end
  def busy_days([], busy_days), do: busy_days
  def busy_days([head | tail], busy_days) do
    if head >= 5, do: busy_days(tail, busy_days + 1), else: busy_days(tail, busy_days)
  end
end
