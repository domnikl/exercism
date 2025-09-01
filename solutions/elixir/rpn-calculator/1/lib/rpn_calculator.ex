defmodule RPNCalculator do
  def calculate!(stack, operation) do
    operation.(stack)
  end

  def calculate(stack, operation) do
    try do
      {:ok, operation.(stack)}
    rescue
      _ -> :error
    end
  end

  @spec calculate_verbose(any(), any()) :: nil
  def calculate_verbose(stack, operation) do
    try do
      {:ok, operation.(stack)}
    rescue
      e in ArgumentError -> {:error, e.message}
    end
  end
end
