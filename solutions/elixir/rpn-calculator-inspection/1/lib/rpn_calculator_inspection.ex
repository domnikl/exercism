defmodule RPNCalculatorInspection do
  def start_reliability_check(calculator, input) do
    pid = spawn_link(fn -> calculator.(input) end)
    %{pid: pid, input: input}
  end

  def await_reliability_check_result(%{pid: pid, input: input}, results) do
    receive do
      {:EXIT, ^pid, :normal} ->
        Map.put(results, input, :ok)

      {:EXIT, ^pid, _} ->
        Map.put(results, input, :error)
    after
      100 ->
        Map.put(results, input, :timeout)
    end
  end

  def reliability_check(calculator, inputs) do
    flag = Process.flag(:trap_exit, true)

    tests =
      Enum.map(inputs, fn input ->
        start_reliability_check(calculator, input)
      end)

    results =
      Enum.reduce(tests, %{}, fn test, acc ->
        await_reliability_check_result(test, acc)
      end)

    Process.flag(:trap_exit, flag)

    results
  end

  def correctness_check(calculator, inputs) do
    tasks = Enum.map(inputs, &Task.async(fn -> calculator.(&1) end))
    Enum.map(tasks, &Task.await(&1, 100))
  end
end
