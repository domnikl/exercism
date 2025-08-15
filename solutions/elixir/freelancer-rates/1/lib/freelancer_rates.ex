defmodule FreelancerRates do

  @doc """
  Calculate the daily rate of a freelancer

  ## Examples

      iex> FreelancerRates.daily_rate(60)
      480.0
  """
  def daily_rate(hourly_rate) do
    hourly_rate * 8.0
  end


  @doc """
  Apply a discount to a rate

  ## Examples

      iex> FreelancerRates.apply_discount(150, 10)
      135.0

  """
  def apply_discount(before_discount, discount) do
    before_discount - (before_discount * discount / 100.0)
  end

  @doc """
  Calculate the monthly rate of a freelancer

  ## Examples

      iex> FreelancerRates.monthly_rate(77, 10.5)
      12130
  """
  def monthly_rate(hourly_rate, discount) do
    apply_discount(daily_rate(hourly_rate) * 22, discount) |> ceil
  end

  @doc """
  Calculate the number of days a freelancer can work within a budget

  ## Examples

      iex> FreelancerRates.days_in_budget(20_000, 80, 11.0)
      2
  """
  def days_in_budget(budget, hourly_rate, discount) do
    budget / apply_discount(daily_rate(hourly_rate), discount) |> Float.floor(1)
  end
end
