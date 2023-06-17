package dialogue;

import java.util.ArrayList;
import java.util.List;

public class DialogueStep {
    String stepID;
    String npcCue;
    List<DialogueOption> playerAnswers;
    DialogueStep nextStep;

    public DialogueStep(String stepID, String npcCue, List<DialogueOption> playerAnswers, DialogueStep nextStep) throws Exception {
        this.stepID = stepID;
        if(npcCue.isBlank()) throw new Exception("NPC cue cannot be blank.");
        this.npcCue = npcCue;
        if(nextStep == null && playerAnswers == null) throw new Exception("Both nextStep and playerAnswers are empty.");
        if(nextStep != null && playerAnswers != null) throw new Exception("Cannot have both nextStep and playerAnswers.");
        this.playerAnswers = playerAnswers;
        this.nextStep = nextStep;
    }

    public String getStepID() {
        return stepID;
    }

    public String getNpcCue() {
        return npcCue;
    }

    public List<DialogueOption> getPlayerAnswers() {
        return playerAnswers;
    }

    public DialogueStep getNextStep() {
        return nextStep;
    }

    public void setNextStep(DialogueStep nextStep) {
        this.nextStep = nextStep;
    }
}
