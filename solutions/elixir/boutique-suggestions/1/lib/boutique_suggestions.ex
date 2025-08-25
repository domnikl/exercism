defmodule BoutiqueSuggestions do
  def get_combinations(tops, bottoms, options \\ []) do
    maximum_price = Keyword.get(options, :maximum_price, 100.0)

    for top <- tops do
      for bottom <- bottoms do
        {top, bottom}
      end
    end
    |> List.flatten()
    |> Enum.filter(fn {t, b} ->
      t.base_color != b.base_color and t.price + b.price < maximum_price
    end)
  end
end
