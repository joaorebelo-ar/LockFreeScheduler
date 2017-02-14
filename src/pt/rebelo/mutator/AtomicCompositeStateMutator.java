package pt.rebelo.mutator;

import pt.rebelo.state.CompositeState;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author joaorebelo-ar
 */
public final class AtomicCompositeStateMutator {

    private final AtomicReference<CompositeState> state;

    private AtomicCompositeStateMutator() {
        this.state = new AtomicReference<>(CompositeState.of(0, true));
    }

    public static AtomicCompositeStateMutator createWithDefaultValues() {
        return new AtomicCompositeStateMutator();
    }

    public final CompositeState get() {
        return state.get();
    }

    public final CompositeState incrementAndGet() {

        return state.accumulateAndGet(
                CompositeState.increment(state.get()),
                (current, updated) -> current.getState() ? updated : current
        );
    }

    public final CompositeState decrementAndGet() {
        return state.accumulateAndGet(
                CompositeState.decrement(state.get()),
                (current, updated) -> current.getState() ? updated : current
        );
    }

    public final CompositeState stop() {
        return state.updateAndGet(value -> CompositeState.changeState(value, false));
    }

    public final boolean isStopped() {
        return !state
                .get()
                .getState();
    }
}
