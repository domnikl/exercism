defmodule BasketballWebsite do
  def extract_from_path(data, path), do: data |> get_in_path(path)

  def get_in_path(data, path) do
    get_in(data, String.split(path, "."))
  end
end
