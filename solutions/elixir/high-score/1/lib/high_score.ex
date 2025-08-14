defmodule HighScore do
  def new() do
    %{}
  end

  def add_player(scores, name) do
    add_player(scores, name, 0)
  end
  def add_player(scores, name, score) do
    Map.merge(scores, %{name => score})
  end

  @spec remove_player(map(), any()) :: map()
  def remove_player(scores, name) do
    Map.delete(scores, name)
  end

  @spec reset_score(map(), any()) :: map()
  def reset_score(scores, name) do
    Map.merge(scores, %{name => 0})
  end

  def update_score(scores, name, new_score) do
    Map.update(scores, name, new_score, fn score -> score + new_score end)
  end

  def get_players(scores) do
    Map.keys(scores)
  end
end
