defmodule TopSecret do
  def to_ast(string) do
    Code.string_to_quoted!(string)
  end

  def decode_secret_message_part(ast, acc) do
    case ast do
      {:def, _, [{:when, _, [{name, _, args}, _]}, _]} ->
        part = extract_info(name, args)
        {ast, [part | acc]}

      {:defp, _, [{:when, _, [{name, _, args}, _]}, _]} ->
        part = extract_info(name, args)
        {ast, [part | acc]}

      {:def, _, [{name, _, args}, _]} ->
        part = extract_info(name, args)
        {ast, [part | acc]}

      {:defp, _, [{name, _, args}, _]} ->
        part = extract_info(name, args)
        {ast, [part | acc]}

      _ ->
        {ast, acc}
    end
  end

  defp extract_info(name, args), do: String.slice(to_string(name), 0, length(args || []))

  def decode_secret_message(string) do
    ast = to_ast(string)

    {_ast, acc} =
      Macro.prewalk(ast, [], fn node, acc ->
        decode_secret_message_part(node, acc)
      end)

    Enum.reverse(acc) |> Enum.join()
  end
end
