defmodule LibraryFees do
  @spec datetime_from_string(String.t()) :: NaiveDateTime.t()
  def datetime_from_string(string) do
    NaiveDateTime.from_iso8601!(string)
  end

  @spec before_noon?(NaiveDateTime.t()) :: boolean()
  def before_noon?(%NaiveDateTime{hour: hour}) when hour < 12, do: true
  def before_noon?(_), do: false

  @spec return_date(NaiveDateTime.t()) :: Date.t()
  def return_date(%NaiveDateTime{} = checkout_datetime) do
    days_to_add = if before_noon?(checkout_datetime), do: 28, else: 29

    checkout_datetime
    |> NaiveDateTime.add(days_to_add, :day)
    |> NaiveDateTime.to_date()
  end

  @spec days_late(Date.t(), NaiveDateTime.t()) :: integer()
  def days_late(planned_return_date, actual_return_datetime) do
    actual = NaiveDateTime.to_date(actual_return_datetime)

    case Date.compare(actual, planned_return_date) do
      :gt -> Date.diff(actual, planned_return_date)
      _ -> 0
    end
  end

  @spec monday?(NaiveDateTime.t()) :: boolean()
  def monday?(datetime) do
    Date.day_of_week(NaiveDateTime.to_date(datetime)) == 1
  end

  @spec calculate_late_fee(String.t(), String.t(), float()) :: float()
  def calculate_late_fee(checkout, return, rate) do
    checkout_datetime = datetime_from_string(checkout)
    return_datetime = datetime_from_string(return)

    days_late = days_late(return_date(checkout_datetime), return_datetime)

    case monday?(return_datetime) do
      true -> trunc(days_late * rate * 0.5)
      false -> days_late * rate
    end
  end
end
