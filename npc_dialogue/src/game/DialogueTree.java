package game;

import dialogue.*;

public class DialogueTree {
    DialogueStep step;

    public DialogueTree(DialogueStep step) {
        this.step = step;
    }

    public DialogueStep getStep() {
        return step;
    }

    DialogueStep findById(String id) throws Exception {
        DialogueStep curr = this.step;
        while(curr != null) {
            if(this.step.getStepID().equals(id)) return this.step;
            curr = curr.getNextStep();
        }
        throw new Exception("No matching step for given ID.");
    }

}
