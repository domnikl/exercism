defmodule LogParser do
  def valid_line?(line) do
    x = ~r/^\[(DEBUG|INFO|WARNING|ERROR)\]/
    Regex.match?(x, line)
  end

  def split_line(line) do
    ~r/<[=*~-]*>/
    |> Regex.split(line)
  end

  def remove_artifacts(line) do
    ~r/end-of-line\d+/i
    |> Regex.replace(line, "")
  end

  def tag_with_user_name(line) do
    matches = ~r/User\s+(\S+)/
    |> Regex.run(line)

    case matches do
      [_, username] -> "[USER] #{username} #{line}"
      _ -> line
    end
  end
end
