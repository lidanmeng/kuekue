package com.kuekue.interview.state;

public final class Controller {

    public State currentState;

    private StateMachine machine;

    private CommandChannel commandChannel;
    
    public Controller(StateMachine machine ,CommandChannel channel){
        currentState = machine.getStart();
        this.machine = machine;
        commandChannel = channel;
    }

    public CommandChannel getCommandChannel() {
        return commandChannel;
    }

    public void setCommandChannel(CommandChannel commandChannel) {
        this.commandChannel = commandChannel;
    }

    public void handle(String code) {
        if (currentState.hasTransition(code)) {
            transitionTo(currentState.getTarget(code));
            return;
        }
        if (machine.isResetEvent(code)) {
            transitionTo(machine.getStart());
        }
    }

    private void transitionTo(State target) {
        currentState = target;
        currentState.executeActions(commandChannel);
    }

}

