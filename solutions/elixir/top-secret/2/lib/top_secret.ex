defmodule TopSecret do
  def to_ast(string) do
    Code.string_to_quoted!(string)
  end

  def decode_secret_message_part({:def, _, definition} = ast, acc),
    do: {ast, [extract_message(definition) | acc]}

  def decode_secret_message_part({:defp, _, definition} = ast, acc),
    do: {ast, [extract_message(definition) | acc]}

  def decode_secret_message_part(ast, acc) do
    {ast, acc}
  end

  defp extract_message([{:when, _, [{name, _, args}, _]}, _]),
    do: String.slice(to_string(name), 0, length(args || []))

  defp extract_message([{name, _, args}, _]),
    do: String.slice(to_string(name), 0, length(args || []))

  def decode_secret_message(string) do
    ast = to_ast(string)

    {_ast, acc} =
      Macro.prewalk(ast, [], fn node, acc ->
        decode_secret_message_part(node, acc)
      end)

    Enum.reverse(acc) |> Enum.join()
  end
end
