package com.kuekue.interview.state;

public class TestState {

    public static void main(String[] args) {

        ActiveEvent opened = new ActiveEvent("门开了......", "opened");
        ActiveEvent closed = new ActiveEvent("门关了......", "closed");

        PassiveEvent open = new PassiveEvent("开门", "open");
        PassiveEvent close = new PassiveEvent("关门", "close");

        State openedState = new State("打开的门");
        State closedState = new State("紧闭的门");

        openedState.addAction(opened);
        closedState.addAction(closed);

        openedState.addTransition(close, closedState);
        closedState.addTransition(open, openedState);

        StateMachine machine = new StateMachine(closedState);
        // Controller control = new Controller(machine, new Channel());
    }

}
