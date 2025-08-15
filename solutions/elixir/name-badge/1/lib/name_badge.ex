defmodule NameBadge do
  def print(nil, name, nil), do: print(nil, name, "OWNER")
  def print(id, name, nil), do: print(id, name, "OWNER")
  def print(id, name, department) do
    case id do
      nil -> "#{name} - #{String.upcase(department)}"
      _ -> "[#{id}] - #{name} - #{String.upcase(department)}"
    end
  end
end
