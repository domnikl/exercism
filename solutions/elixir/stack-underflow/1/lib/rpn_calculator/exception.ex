defmodule RPNCalculator.Exception do
  defmodule DivisionByZeroError do
    defexception message: "division by zero occurred"
  end

  defmodule StackUnderflowError do
    defexception message: "stack underflow occurred"

    @impl true
    def exception(value) do
      case value do
        [] ->
          %StackUnderflowError{}

        _ ->
          %StackUnderflowError{message: "stack underflow occurred, context: " <> value}
      end
    end
  end

  def divide(l) when length(l) < 2,
    do: raise(StackUnderflowError, "when dividing")

  def divide([0 | _tail]), do: raise(DivisionByZeroError)
  def divide([head | tail]), do: List.first(tail) / head
end
