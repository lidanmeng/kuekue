package com.kuekue.interview.state;

public final class Transition {

    private State source;

    private State target;

    private PassiveEvent trigger;

    public Transition(State source, State target, PassiveEvent trigger) {
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return source;
    }

    public void setSource(State source) {
        this.source = source;
    }

    public State getTarget() {
        return target;
    }

    public void setTarget(State target) {
        this.target = target;
    }

    public PassiveEvent getTrigger() {
        return trigger;
    }

    public void setTrigger(PassiveEvent trigger) {
        this.trigger = trigger;
    }

}
