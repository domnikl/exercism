defmodule Chessboard do
  def rank_range do
    1..8
  end

  def file_range do
    ?A..?H
  end

  def ranks do
    for rank <- rank_range(), do: rank
  end

  def files do
    for file <- file_range(), do: List.to_string([file])
  end
end
