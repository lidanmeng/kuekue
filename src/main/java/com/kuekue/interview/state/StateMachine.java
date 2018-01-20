package com.kuekue.interview.state;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {

    private State start;

    public State getStart() {
        return start;
    }

    public void setStart(State start) {
        this.start = start;
    }

    public StateMachine(State start) {
        this.start = start;
    }

    public List<State> allStates() {
        List<State> result = new ArrayList<>();
        collectStates(result, start);
        return result;
    }

    private void collectStates(List<State> result, State state) {
        if (result.contains(state)) {
            return;
        }
        result.add(state);
        for (State s : state.allTargets()) {
            collectStates(result, s);
        }
    }

    private List<PassiveEvent> resetEvents = new ArrayList<>();

    public void addResetEvent(PassiveEvent e) {
        for (State s : allStates()) {
            if (s.hasTransition(e.getCode())) {
                continue;
            }
            s.addTransition(e, start);
            if (resetEvents.contains(e)) {
                continue;
            }
            resetEvents.add(e);
        }
    }

    public boolean isResetEvent(String code) {
        List<String> resetCodes = new ArrayList<String>();
        for (PassiveEvent e : resetEvents) {
            resetCodes.add(e.getCode());
        }
        return resetCodes.contains(code);
    }



}
