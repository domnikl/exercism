defmodule Markdown do
  @doc """
    Parses a given string with Markdown syntax and returns the associated HTML for that string.

    ## Examples

      iex> Markdown.parse("This is a paragraph")
      "<p>This is a paragraph</p>"

      iex> Markdown.parse("# Header!\\n* __Bold Item__\\n* _Italic Item_")
      "<h1>Header!</h1><ul><li><strong>Bold Item</strong></li><li><em>Italic Item</em></li></ul>"
  """
  @spec parse(String.t()) :: String.t()
  def parse(markdown),
    do: markdown |> String.split("\n") |> Enum.map_join(&process_line/1) |> inner_tags

  defp process_line("#######" <> _ = full_line), do: wrap_with_tag(full_line, "p")
  defp process_line("#" <> _ = line), do: header(line)
  defp process_line("* " <> line), do: line |> wrap_with_tag("li")
  defp process_line(line), do: line |> wrap_with_tag("p")

  defp header(line) do
    [level, text] = String.split(line, " ", parts: 2)
    text |> wrap_with_tag("h#{String.length(level)}")
  end

  defp inner_tags(text) do
    text
    |> String.replace(~r/__(.+)__/U, "<strong>\\1</strong>")
    |> String.replace(~r/_(.+)_/U, "<em>\\1</em>")
    |> String.replace(~r/(<li>.+<\/li>)/, "<ul>\\1</ul>")
  end

  defp wrap_with_tag(text, tag), do: "<#{tag}>#{text}</#{tag}>"
end
