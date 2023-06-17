package dialogue;

import java.util.List;

public class DialogueOption {
    String playerCue;
    DialogueStep nextStep;
    List<Object> modifiers;

    public DialogueOption(String playerCue, DialogueStep nextStep, List<Object> modifiers) {
        this.playerCue = playerCue;
        this.nextStep = nextStep;
        this.modifiers = modifiers;
    }

    public String getPlayerCue() {
        return playerCue;
    }

    public DialogueStep getNextStep() {
        return nextStep;
    }

    public void setNextStep(DialogueStep nextStep) {
        this.nextStep = nextStep;
    }

    public List<Object> getModifiers() {
        return modifiers;
    }

    public void modify(Object option) {
        this.modifiers.add(option);
    }
}
