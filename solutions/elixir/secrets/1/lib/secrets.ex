defmodule Secrets do

  @doc """
  Adds a secret number to a given number.

  ## Examples:

    iex> secret_add_5 = Secrets.secret_add(5)
    iex> secret_add_5.(3)
    8
  """
  def secret_add(secret) do
    fn x -> x + secret end
  end

  def secret_subtract(secret) do
    fn x -> x - secret end
  end

  def secret_multiply(secret) do
   fn x -> x * secret end
  end

  def secret_divide(secret) do
    fn x -> x |> div(secret) end
  end

  def secret_and(secret) do
    fn x -> secret |> Bitwise.band(x) end
  end

  def secret_xor(secret) do
    fn x -> secret |> Bitwise.bxor(x) end
  end

  def secret_combine(secret_function1, secret_function2) do
    fn x -> x |> secret_function1.() |> secret_function2.() end
  end
end
