# Use the Plot struct as it is provided
defmodule Plot do
  @enforce_keys [:plot_id, :registered_to]
  defstruct [:plot_id, :registered_to]
end

defmodule CommunityGarden do
  @spec start() :: {:error, any()} | {:ok, pid()}
  def start(opts \\ []) do
    Agent.start_link(fn -> %{plot_id: 1, registrations: %{}} end, opts)
  end

  @spec list_registrations(atom() | pid() | {atom(), any()} | {:via, atom(), any()}) :: any()
  def list_registrations(pid) do
    Agent.get(pid, fn state -> Map.values(state.registrations) end)
  end

  @spec register(atom() | pid() | {atom(), any()} | {:via, atom(), any()}, any()) :: any()
  def register(pid, register_to) do
    Agent.get_and_update(pid, fn state ->
      new_registration = %Plot{plot_id: state.plot_id, registered_to: register_to}

      new_state = %{
        state
        | plot_id: state.plot_id + 1,
          registrations: Map.put(state.registrations, new_registration.plot_id, new_registration)
      }

      {new_registration, new_state}
    end)
  end

  @spec release(atom() | pid() | {atom(), any()} | {:via, atom(), any()}, any()) :: :ok
  def release(pid, plot_id) do
    Agent.update(pid, fn state ->
      %{
        state
        | registrations: Map.delete(state.registrations, plot_id)
      }
    end)
  end

  @spec get_registration(atom() | pid() | {atom(), any()} | {:via, atom(), any()}, any()) :: any()
  def get_registration(pid, plot_id) do
    Agent.get(pid, fn state ->
      case Map.get(state.registrations, plot_id) do
        nil -> {:not_found, "plot is unregistered"}
        plot -> plot
      end
    end)
  end
end
