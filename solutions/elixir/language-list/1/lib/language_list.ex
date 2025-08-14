defmodule LanguageList do
  def new() do
    []
  end

  def add(list, language) do
    [language | list]
  end

  def remove(list) do
    [ _ | tail ] = list
    tail
  end

  def first(list) do
    [ head | _ ] = list
    head
  end

  def count(list) do
    Enum.count(list)
  end

  def functional_list?(list) do
    Enum.any?(list, fn x -> x == "Elixir" end)
  end
end
