package com.kuekue.interview.state;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class State {

    private String name;

    public State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<ActiveEvent> actions = new ArrayList<>();

    public void addAction(ActiveEvent e) {
        if (actions.contains(e)) {
            return;
        }
        actions.add(e);
    }

    private List<PassiveEvent> fires = new ArrayList<>();

    public void addFire(PassiveEvent e) {
        if (fires.contains(e)) {
            return;
        }
        fires.add(e);
    }

    private Map<String, Transition> transitions = new HashMap<String, Transition>();

    public void addTransition(PassiveEvent e, State target) {
        transitions.put(e.getCode(), new Transition(this, target, e));
    }

    public List<State> allTargets() {
        List<State> list = new ArrayList<State>();
        for (Entry<String, Transition> entry : transitions.entrySet()) {
            list.add(entry.getValue().getTarget());
        }
        return list;
    }

    public boolean hasTransition(String code) {
        return transitions.containsKey(code);
    }

    public State getTarget(String code) {
        return transitions.get(code).getTarget();
    }

    public void executeActions(CommandChannel channel) {}
}
