defmodule LogLevel do
  def to_label(level, legacy?) do
    label = case level do
      0 -> :trace
      1 -> :debug
      2 -> :info
      3 -> :warning
      4 -> :error
      5 -> :fatal
      _ -> :unknown
    end

    if legacy? and level in [0, 5] do
      :unknown
    else
      label
    end
  end

  def alert_recipient(level, legacy?) do
    label = to_label(level, legacy?)

    case {label, legacy?} do
      {:error, _} -> :ops
      {:fatal, _} -> :ops
      {:unknown, true} -> :dev1
      {:unknown, false} -> :dev2
      {_, _} -> false
    end
  end
end
