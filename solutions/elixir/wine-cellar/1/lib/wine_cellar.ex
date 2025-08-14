defmodule WineCellar do
  def explain_colors do
    [
      white: "Fermented without skin contact.",
      red: "Fermented with skin contact using dark-colored grapes.",
      rose: "Fermented with some skin contact, but not enough to qualify as a red wine."
    ]
  end

  def filter(cellar, color, opts \\ []) do
    cellar
    |> filter_by_color(color)
    |> filter_by_year(opts[:year])
    |> filter_by_country(opts[:country])
  end

  defp filter_by_color(cellar, color)
  defp filter_by_color([], _color), do: []

  defp filter_by_color([{color, wine_data} | tail], c) when color == c do
    [wine_data | filter_by_color(tail, c)]
  end

  defp filter_by_color([_ | tail], color) do
    filter_by_color(tail, color)
  end

  # The functions below do not need to be modified.

  defp filter_by_year(wines, year)
  defp filter_by_year(wines, nil), do: wines
  defp filter_by_year([], _year), do: []

  defp filter_by_year([{_, y, _} = wine | tail], year) when year == y do
    [wine | filter_by_year(tail, year)]
  end

  defp filter_by_year([{_, _, _} | tail], year), do: filter_by_year(tail, year)

  defp filter_by_country(wines, country)
  defp filter_by_country(wines, nil), do: wines
  defp filter_by_country([], _country), do: []

  defp filter_by_country([{_, _, c} = wine | tail], country) when c == country do
    [wine | filter_by_country(tail, country)]
  end

  defp filter_by_country([{_, _, _} | tail], country) do
    filter_by_country(tail, country)
  end
end
