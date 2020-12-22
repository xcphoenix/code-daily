package kights;

/**
 * ClassName    Spring1-BraveKnight
 * Description
 * @author      xuanc
 * @date        19-3-18 下午3:17
 * @version     1.0
 */ 
public class BraveKnight implements Knight {

    private Quest quest;

    public BraveKnight(Quest quest) {
        this.quest = quest;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
