defmodule Username do
  def sanitize([]), do: []
  def sanitize(username) do
    sanitize(username, [])
  end

  defp sanitize([], sanitized), do: sanitized
  defp sanitize([head | tail], sanitized) do
    sanitized ++ case head do
      ?ß -> sanitize(tail, ~c"ss")
      ?ä -> sanitize(tail, ~c"ae")
      ?ö -> sanitize(tail, ~c"oe")
      ?ü -> sanitize(tail, ~c"ue")
      c when c in ?a..?z -> sanitize(tail, [head])
      ?_ -> sanitize(tail, [?_])
      _ -> sanitize(tail, [])
    end
  end
end
