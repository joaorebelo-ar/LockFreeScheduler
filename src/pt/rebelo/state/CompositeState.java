package pt.rebelo.state;

/**
 * @author joaorebelo-ar
 */
public final class CompositeState {

    private final long accumulator;
    private final boolean state;

    private CompositeState(long composite1, boolean composite2) {
        this.accumulator = composite1;
        this.state = composite2;
    }

    public static CompositeState of(long composite1, boolean composite2) {
        return new CompositeState(composite1, composite2);
    }

    public static CompositeState increment(CompositeState state){
        return of(state.accumulator +1, state.getState());
    }

    public static CompositeState decrement(CompositeState state){
        return of(state.accumulator - 1,state.getState());
    }

    public static CompositeState changeState(CompositeState state, boolean newState){
        return of(state.accumulator,newState);
    }

    public final long getAccumulator(){
        return accumulator;
    }

    public final boolean getState(){
        return state;
    }

    @Override
    public String toString() {
        return "CompositeState{" +
                "accumulator=" + accumulator +
                ", state=" + state +
                '}';
    }
}
