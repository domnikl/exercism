defmodule NameBadge do
  def print(nil, name, nil), do: print(nil, name, "OWNER")
  def print(id, name, nil), do: print(id, name, "OWNER")
  def print(id, name, department) do
    if id == nil do
      "#{name} - #{String.upcase(department)}"
    else
      "[#{id}] - #{name} - #{String.upcase(department)}"
    end
  end
end
