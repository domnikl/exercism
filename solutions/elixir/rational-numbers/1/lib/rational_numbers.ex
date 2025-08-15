defmodule RationalNumbers do
  @type rational :: {integer, integer}

  @doc """
  Add two rational numbers
  """
  @spec add(a :: rational, b :: rational) :: rational
  def add(a, b) do
    {a1, a2} = a
    {b1, b2} = b
    {a1 * b2 + b1 * a2, a2 * b2} |> reduce()
  end

  @doc """
  Subtract two rational numbers
  """
  @spec subtract(a :: rational, b :: rational) :: rational
  def subtract(a, b) do
    {a1, a2} = a
    {b1, b2} = b
    {a1 * b2 - b1 * a2, a2 * b2} |> reduce()
  end

  @doc """
  Multiply two rational numbers
  """
  @spec multiply(a :: rational, b :: rational) :: rational
  def multiply(a, b) do
    {a1, a2} = a
    {b1, b2} = b
    {a1 * b1, a2 * b2} |> reduce()
  end

  @doc """
  Divide two rational numbers
  """
  @spec divide_by(num :: rational, den :: rational) :: rational
  def divide_by(num, den) do
    {num1, num2} = num
    {den1, den2} = den
    {num1 * den2, num2 * den1} |> reduce()
  end

  @doc """
  Absolute value of a rational number
  """
  @spec abs(a :: rational) :: rational
  def abs(a) do
    {num, den} = a
    {Kernel.abs(num), Kernel.abs(den)} |> reduce()
  end

  @doc """
  Exponentiation of a rational number by an integer
  """
  @spec pow_rational(a :: rational, n :: integer) :: rational
  def pow_rational(a, n) do
    {num, den} = a

    cond do
      n == 0 -> {1, 1}
      n > 0 -> {num ** n, den ** n}
      n < 0 -> {den ** Kernel.abs(n), num ** Kernel.abs(n)}
    end
    |> reduce()
  end

  @doc """
  Exponentiation of a real number by a rational number
  """
  @spec pow_real(x :: integer, n :: rational) :: float
  def pow_real(x, n) do
    {num, den} = n
    :math.pow(x, num / den)
  end

  @doc """
  Reduce a rational number to its lowest terms
  """
  @spec reduce(a :: rational) :: rational
  def reduce(a) do
    {num, den} = a
    gcd = Integer.gcd(Kernel.abs(num), Kernel.abs(den))
    reduced_num = div(num, gcd)
    reduced_den = div(den, gcd)

    # Ensure the minus sign is on the numerator
    cond do
      reduced_den < 0 -> {-reduced_num, -reduced_den}
      true -> {reduced_num, reduced_den}
    end
  end
end
