defmodule BoutiqueSuggestions do
  def get_combinations(tops, bottoms, options \\ []) do
    maximum_price = Keyword.get(options, :maximum_price, 100.0)

    for top <- tops do
      for bottom <- bottoms do
        {top, bottom}
      end
    end
    |> flatten()
    |> filter(fn {t, b} ->
      t.base_color != b.base_color and t.price + b.price < maximum_price
    end)
  end

  defp flatten([]), do: []
  defp flatten([ head | tail ]), do: flatten(head) ++ flatten(tail)
  defp flatten(head), do: [head]

  defp filter([], _), do: []
  defp filter(collection, fun) when is_function(fun, 1) do
    for x <- collection, fun.(x), do: x
  end
end
